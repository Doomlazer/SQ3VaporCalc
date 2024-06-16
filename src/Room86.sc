;;; Sierra Script 1.0 - (do not remove this comment)
(script# 86)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Avoid)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room86 0
)

(instance door of Prop
	(properties)
)

(instance Room86 of Rm
	(properties
		picture 86
	)
	
	(method (init)
		(super init:)
		(proc0_1)
		(proc0_2)
		(door view: 125 loop: 0 cel: 0 posn: 161 136 init:)
		(switch gNorth
			(90
				(gEgo view: 0 init: posn: 159 130)
				(global2 setScript: inFromNinety)
			)
			(else 
				(proc0_1)
				(gEgo
					view: 123
					loop: 3
					posn: 159 155
					observeControl: 16384
					init:
				)
				(global2 setScript: Actions)
			)
		)
		(if (gEgo has: 12) (gEgo view: 113))
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if (& (gEgo onControl: 0) $0040)
			(global2 newRoom: 85)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(if (== (pEvent type?) evSAID)
				(cond 
					((Said 'look>')
						(cond 
							(
								(or
									(Said '/area')
									(Said '/around')
									(Said '[<around][/!*]')
								)
								(proc255_0 86 0)
							)
							((Said '/door,elevator') (proc255_0 86 1))
							((Said '/partition') (proc255_0 86 2))
							((Said '/ramp,stair') (proc255_0 86 3))
							((Said '/button') (proc255_0 86 4))
						)
					)
					((Said 'open/door') (proc255_0 86 5))
					((Said 'press/button') (gEgo setScript: pushButton))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not global597)
			(= global597 1)
			(gGame changeScore: 25)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance Actions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(proc0_2)
				(gEgo setMotion: 0 view: 134 setLoop: 4 setCycle: Fwd)
				(proc0_10)
				(= seconds 2)
			)
			(2
				(gEgo setLoop: 3 cel: 0)
				(proc0_10)
				(proc255_0 86 6)
				(= seconds 2)
			)
			(3
				(gEgo setLoop: 1)
				(= seconds 2)
			)
			(4
				(proc0_1)
				(gEgo view: 0 loop: 2)
				(= global120 2)
				(= global105 0)
				(proc0_10)
				(proc255_0 86 7)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance inFromNinety of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(door ignoreActors: setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 159 155 self)
			)
			(2
				(door setCycle: Beg self)
				(proc0_1)
				(gEgo observeControl: 16384)
				(proc0_3)
			)
		)
	)
)

(instance pushButton of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setAvoider: Avoid setMotion: MoveTo 134 143 self)
			)
			(1 (= seconds 2))
			(2
				(gEgo setAvoider: 0)
				(door setCycle: End self)
			)
			(3
				(door ignoreActors:)
				(gEgo ignoreControl: 16384 setMotion: MoveTo 159 141 self)
			)
			(4
				(gEgo setMotion: MoveTo 159 130 self)
			)
			(5
				(gEgo loop: 2)
				(door setCycle: Beg self)
			)
			(6 (global2 newRoom: 90))
		)
	)
)
