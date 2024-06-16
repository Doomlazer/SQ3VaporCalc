;;; Sierra Script 1.0 - (do not remove this comment)
(script# 72)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Obj)

(public
	rm072 0
)

(instance rm072 of Rm
	(properties
		picture 72
		north 74
		south 71
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(super init:)
		(switch gNorth
			(71
				(gEgo
					init:
					posn:
						(cond 
							((< (gEgo x?) 67) 67)
							((< (gEgo x?) 193) 193)
							(else (gEgo x?))
						)
						187
				)
				(proc0_10)
				(if global256
					(gLongSong number: 71 loop: -1 priority: 0 play:)
				else
					(gLongSong number: 51 loop: -1 priority: 0 play:)
				)
				(proc255_0 72 0)
			)
			(74
				(global2 setScript: EnterScript)
			)
		)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if
		(and (== (gEgo onControl:) 3) (not (global2 script?)))
			(self setScript: LeaveScript)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look/device,building,generator')
				(cond 
					((not global256) (if global170 (proc255_0 72 1) else (proc255_0 72 2)))
					(global170 (proc255_0 72 3))
					(else (proc255_0 72 4))
				)
			)
			((Said 'look/beam')
				(if (not global256)
					(if global170 (proc255_0 72 5) else (proc255_0 72 6))
				else
					(proc255_0 72 7)
				)
			)
			((Said 'look/butte') (proc255_0 72 8))
		)
	)
)

(instance EnterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setPri: 3
					setLoop: 0
					illegalBits: 0
					posn: 217 156
					init:
					setMotion: MoveTo 241 132 self
				)
			)
			(1
				(gEgo setLoop: 2 setMotion: MoveTo 241 144 self)
			)
			(2
				(gEgo setLoop: -1 illegalBits: -32768 setPri: -1)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance LeaveScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setPri: 3
					setLoop: 1
					illegalBits: 0
					setMotion: MoveTo 217 156 self
				)
			)
			(1
				(gEgo setLoop: -1)
				(proc0_3)
				(if global256 (++ global593))
				(global2 newRoom: 74)
			)
		)
	)
)
