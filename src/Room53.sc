;;; Sierra Script 1.0 - (do not remove this comment)
(script# 53)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	Room53 0
)

(instance hissing of Sound
	(properties)
)

(instance aSnake of Act
	(properties)
)

(instance tongue of Prop
	(properties)
)

(instance snakeSound of Sound
	(properties)
)

(instance Room53 of Rm
	(properties
		picture 53
	)
	
	(method (init)
		(= north gNorth)
		(= global109 0)
		(Load rsSOUND 36)
		(Load rsSOUND 37)
		(Load rsSOUND 88)
		(Load rsSOUND 89)
		(self setRegions: 501)
		(super init:)
		(proc0_1)
		(gLongSong stop:)
		(User canControl: 0 canInput: 1)
		(gEgo
			posn: 155 95
			view: 0
			init:
			setMotion: MoveTo 155 105
		)
		(aSnake
			view: 77
			posn: -40 150
			setPri: 14
			setLoop: 0
			cel: 0
			setStep: 4 3
			ignoreActors: 1
			ignoreHorizon:
			illegalBits: 0
			init:
		)
		(aSnake setScript: snakeActions)
		(global2 setScript: Actions)
	)
	
	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
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
								(proc255_0 53 0)
							)
							((Said '/cruncher') (proc255_0 53 1))
							((Said '/snake') (proc255_0 53 2))
						)
					)
					((Said 'kiss/cruncher') (proc255_0 53 3))
					((Said 'attack/cruncher') (proc255_0 53 4))
					((Said 'jog') (proc255_0 53 5))
					((Said 'feed/cruncher') (proc255_0 53 6))
					((Said 'converse/cruncher') (proc255_0 53 7))
					((Said 'bridle/cruncher') (proc255_0 53 8) (gGame changeScore: -5))
					((Said 'charm/cruncher') (proc255_0 53 9))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong number: 22 priority: 0 loop: -1 play:)
		(proc0_3)
		(= global104 0)
		(super newRoom: newRoomNumber)
	)
)

(instance Actions of Script
	(properties)
	
	(method (changeState)
	)
)

(instance snakeActions of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if (== state 4)
			(cond 
				((or (!= (gEgo x?) 155) (> (gEgo y?) 105))
					(User canControl: 0 canInput: 1)
					(= seconds 0)
					(self changeState: 5)
				)
				(
				(and (<= (gEgo y?) 95) (== gGNorth gNewRoomNumber)) (User canControl: 0 canInput: 1) (self changeState: 10))
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSnake setMotion: MoveTo -22 94 self)
			)
			(1
				(aSnake setMotion: MoveTo -43 55 self)
			)
			(2
				(aSnake setMotion: MoveTo 0 62 self)
			)
			(3
				(if (IsObject (gEgo mover?))
					(-- state)
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(4
				(tongue
					view: 77
					loop: 2
					posn: 133 83
					setPri: 13
					setCycle: Fwd
					setScript: hiss
					init:
				)
				(proc0_3)
				(= seconds 12)
			)
			(5
				(proc0_2)
				(hissing stop:)
				(hiss changeState: 3)
				(tongue setScript: 0 dispose:)
				(aSnake setCycle: End self)
				(snakeSound priority: 19 number: 89 play:)
			)
			(6
				(aSnake cel: 0)
				(global2 horizon: 0)
				(gEgo
					view: 77
					setLoop: 3
					posn: 141 89
					ignoreActors:
					setCycle: Fwd
					setStep: 1 1
					moveSpeed: 2
					setMotion: MoveTo 126 87
				)
				(= seconds 7)
			)
			(7
				(gEgo setLoop: 4 setCel: 0 posn: 137 88)
				(snakeSound priority: 19 number: 88 play:)
				(aSnake cel: 1)
				(= seconds 1)
			)
			(8
				(gEgo hide:)
				(aSnake cel: 0)
				(= seconds 3)
			)
			(9 (proc0_17 901 0 13 19))
			(10
				(tongue dispose:)
				(gEgo setMotion: MoveTo (gEgo x?) 70 self)
			)
			(11 (global2 newRoom: gNorth))
		)
	)
)

(instance hiss of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(hissing number: 37 priority: 10 loop: 2 play: self)
			)
			(1 (= state -1) (= seconds 4))
		)
	)
)
