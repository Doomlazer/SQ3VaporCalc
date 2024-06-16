;;; Sierra Script 1.0 - (do not remove this comment)
(script# 54)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room54 0
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance explosion of Sound
	(properties)
)

(instance Room54 of Rm
	(properties
		picture 54
	)
	
	(method (init)
		(= south gNorth)
		(Load rsPIC 540)
		(Load rsVIEW 79)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(Load rsSOUND 33)
		(super init:)
		(proc0_1)
		(gEgo init:)
		(lightning
			view: 69
			loop: 8
			cel: 0
			posn: 99 75
			setScript: flash
			init:
		)
		(= global104 0)
		(gEgo posn: 157 188 view: 0 loop: 3)
		(global2 setScript: Actions)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(if
			(and (== (pEvent type?) evSAID) (Said 'look>'))
				(cond 
					(
						(or
							(Said '/area')
							(Said '/around')
							(Said '[<around][/!*]')
						)
						(proc255_0 54 0)
					)
					((Said '/butte,toe') (proc255_0 54 1))
					((or (Said '/cloud,air') (Said '<up')) (proc255_0 54 2))
					((Said '/desert') (proc255_0 54 3))
					((Said '/dirt,dirt') (proc255_0 54 4))
					((Said '/lightning') (proc255_0 54 5))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(DisposeScript 988)
		(if (not global155) (super newRoom: newRoomNumber))
	)
)

(instance Actions of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
			(and
				(== state 0)
				(or (!= (gEgo x?) 157) (<= (gEgo y?) 185))
			)
			(= seconds 0)
			(self changeState: 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 8))
			(1
				(proc0_2)
				(explosion number: 33 priority: 34 play:)
				(global2 overlay: 540 5)
				(gEgo
					view: 79
					loop: 1
					cel: 255
					cycleSpeed: 1
					setCycle: End self
				)
				(= cycles 1)
			)
			(2
				(ShakeScreen 8)
				(global2 drawPic: 54 4)
			)
			(3 (= seconds 7))
			(4 (proc0_17 901 0 11 18))
		)
	)
)

(instance flash of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 5 15)))
			(1
				(lightning cel: 255 setCycle: End self)
			)
			(2
				(lightning cel: 0)
				(= seconds (Random 2 5))
			)
			(3
				(thunder priority: 2 number: (Random 31 32) play: self)
			)
			(4 (= state -1))
		)
	)
)
