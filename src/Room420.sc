;;; Sierra Script 1.0 - (do not remove this comment)
(script# 420)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room420 0
)

(instance elevTop of View
	(properties)
)

(instance elevBottom of View
	(properties)
)

(instance cable1 of View
	(properties)
)

(instance cable2 of View
	(properties)
)

(instance cable3 of View
	(properties)
)

(instance cable4 of View
	(properties)
)

(instance Room420 of Rm
	(properties
		picture 420
	)
	
	(method (init)
		(= global104 0)
		(super init:)
		(gEgo init:)
		(switch gNorth
			(42
				(proc0_1)
				(gEgo posn: 93 156)
				(elevTop
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 12
					loop: 1
					cel: 1
					init:
					stopUpd:
				)
				(elevBottom
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 7
					loop: 1
					cel: 0
					init:
					stopUpd:
				)
				(cable1
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 80
					setPri: 10
					init:
					stopUpd:
				)
				(cable2
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 42
					setPri: 10
					init:
					stopUpd:
				)
				(cable3
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 12
					setPri: 10
					init:
					stopUpd:
				)
				(cable4
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 0
					setPri: 10
					init:
					stopUpd:
				)
			)
			(421
				(gEgo view: 83 setLoop: 1 setCel: 2 posn:)
				(cable1
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 80
					setPri: 10
					init:
					stopUpd:
				)
				(cable2
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 42
					setPri: 10
					init:
					stopUpd:
				)
				(cable3
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 12
					setPri: 10
					init:
					stopUpd:
				)
				(cable4
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 0
					setPri: 10
					init:
					stopUpd:
				)
				(global2 setScript: lowerElevator)
			)
		)
		(gEgo init:)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if (& (gEgo onControl: 1) $0040)
			(global2 newRoom: 42)
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
								(proc255_0 420 0)
							)
							((Said '/elevator') (proc255_0 420 1))
							((Said '/button,console,control') (proc255_0 420 2))
							((Said '<up') (proc255_0 420 3))
							((Said '/pit') (proc255_0 420 4))
							(else (proc255_0 420 5) (pEvent claimed: 1))
						)
					)
					(
						(or
							(Said 'press/button')
							(Said 'use/elevator')
							(Said 'press<up/')
						)
						(if (gEgo inRect: 150 147 180 158)
							(global2 setScript: raise)
						else
							(proc0_5)
						)
					)
					((Said 'press<down') (proc255_0 420 6))
					((Said 'climb') (proc255_0 420 7))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 421)
			(gLongSong
				owner: -1
				number: 22
				priority: 1
				loop: -1
				play:
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance raise of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(cond 
			((< (Abs (- (gEgo y?) (cable1 y?))) 2) (cable1 dispose:))
			((< (Abs (- (gEgo y?) (cable2 y?))) 2) (cable2 dispose:))
			((< (Abs (- (gEgo y?) (cable3 y?))) 2) (cable3 dispose:))
			((< (Abs (- (gEgo y?) (cable4 y?))) 2) (cable4 dispose:))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 164 153 self)
			)
			(1
				(gEgo view: 83 cel: 255 setLoop: 0 setCycle: End self)
			)
			(2
				(gEgo
					ignoreActors:
					illegalBits: 0
					setLoop: 1
					setCel: 2
					posn: 164 (elevTop y?)
					setPri: 11
					setMotion: MoveTo 164 -60 self
				)
				(elevTop dispose:)
				(elevBottom dispose:)
			)
			(3 (global2 newRoom: 421))
		)
	)
)

(instance lowerElevator of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(cond 
			((< (Abs (- (gEgo y?) (cable1 y?))) 2) (cable1 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:))
			((< (Abs (- (gEgo y?) (cable2 y?))) 2) (cable2 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:))
			((< (Abs (- (gEgo y?) (cable3 y?))) 2) (cable3 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:))
			((< (Abs (- (gEgo y?) (cable4 y?))) 2) (cable4 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 83
					ignoreActors:
					illegalBits: 0
					setLoop: 1
					setCel: 2
					posn: 164 -60
					setPri: 11
					setMotion: MoveTo 164 112 self
				)
			)
			(1
				(elevTop
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 12
					loop: 1
					cel: 1
					init:
					stopUpd:
				)
				(elevBottom
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 7
					loop: 1
					cel: 0
					init:
					stopUpd:
				)
				(proc0_1)
				(gEgo
					view: 0
					setLoop: -1
					setCel: -1
					setCycle: Walk
					illegalBits: -32768
					posn: 164 153
				)
				(proc0_3)
			)
		)
	)
)
