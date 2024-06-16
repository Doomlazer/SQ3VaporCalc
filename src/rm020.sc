;;; Sierra Script 1.0 - (do not remove this comment)
(script# 20)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm020 0
)

(instance rm020 of Rm
	(properties
		picture 20
	)
	
	(method (init &tmp [temp0 50])
		(proc0_2)
		(= global159 1)
		(Load rsVIEW 759)
		(= global207 1)
		(super init:)
		(self setScript: rmScript)
	)
	
	(method (doit)
		(if (and (== global220 1) (== script 0))
			(proc255_0 20 0)
			(= global159 0)
			(global2 newRoom: 17)
		)
		(super doit:)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 20 1 67 -1 130 70 280)
				(hole init: addToPic:)
				(blowUp play:)
				(if (== global205 0)
					(blast init: setCycle: CT 1 1 self)
				else
					(blast init: setCycle: End self)
				)
			)
			(1
				(if (== global205 0)
					(ship init: setCycle: End self)
					(blast setCycle: End)
				else
					(= cycles 2)
				)
			)
			(2
				(if (== global205 0)
					(ship setLoop: 4 cel: 0 setMotion: 0 setCycle: End self)
				else
					(ship
						init:
						setLoop: 2
						setCycle: Fwd
						setMotion: MoveTo 340 83 self
					)
				)
			)
			(3
				(blast dispose:)
				(if (!= global205 0)
					(proc255_0 20 2 67 -1 130 70 280)
					(gGame changeScore: 25)
					(= global210 1)
					(= global206 3)
					(= global159 0)
					(global2 newRoom: 14)
				else
					(proc255_0 20 3 67 -1 130 70 280)
					(proc0_17 0 0 4 5)
				)
			)
		)
	)
)

(instance blast of Prop
	(properties
		view 759
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			cel: 0
			cycleSpeed: 1
			setPri: 5
			posn: 155 77
			ignoreActors: 1
		)
	)
)

(instance hole of View
	(properties
		view 759
	)
	
	(method (init)
		(super init:)
		(self setLoop: 1 setPri: 4 posn: 170 95 ignoreActors: 1)
	)
)

(instance ship of Act
	(properties
		view 759
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 3
			cel: 0
			posn: 167 83
			cycleSpeed: 2
			ignoreActors: 1
			setStep: 10 1
		)
	)
)

(instance blowUp of Sound
	(properties
		number 33
		priority 1
	)
)
