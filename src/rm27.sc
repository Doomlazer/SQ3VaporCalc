;;; Sierra Script 1.0 - (do not remove this comment)
(script# 27)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm27 0
)

(instance rm27 of Rm
	(properties
		picture 27
	)
	
	(method (init &tmp [temp0 50])
		(proc0_2)
		(Load rsVIEW 39)
		(Load rsVIEW 52)
		(Load rsSOUND 16)
		(if (not global158) (enterprise init: stopUpd:))
		(ship init:)
		(super init:)
		(= global206 3)
		(gEgo
			setLoop: -1
			setCel: -1
			setPri: -1
			cycleSpeed: 0
			moveSpeed: 0
			setStep: 3 2
		)
		(gLongSong number: 16 loop: -1 play:)
		(self setScript: arrivalScript)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look[/area,monolith,burger,cafe]')
					(proc255_0 27 0)
				)
			)
		)
	)
)

(instance arrivalScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship
					setCycle: End
					setStep: 3 1
					setMotion: MoveTo 201 98 self
				)
			)
			(1
				(ship
					posn: 201 98
					setStep: 1 1
					setCycle: 0
					setMotion: MoveTo 205 98 self
				)
			)
			(2
				(ship setMotion: MoveTo 215 108 self)
			)
			(3
				(ship setMotion: MoveTo 215 116 self)
			)
			(4
				(ship setMotion: MoveTo 208 122 self)
				(if (not global158) (global2 setScript: entScript))
			)
			(5
				(ship setMotion: MoveTo 198 122 self)
			)
			(6
				(ship dispose:)
				(if global158 (= global206 1) (global2 newRoom: 28))
			)
		)
	)
)

(instance entScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(enterprise setMotion: MoveTo 92 107 self)
			)
			(1
				(enterprise setMotion: MoveTo 82 97 self)
			)
			(2 (= seconds 2))
			(3
				(enterprise setStep: 3 3 setMotion: MoveTo 76 103 self)
			)
			(4
				(enterprise setCycle: End self)
			)
			(5
				(enterprise dispose:)
				(= global206 1)
				(= global158 1)
				(global2 newRoom: 28)
			)
		)
	)
)

(instance ship of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 52
			cel: 0
			posn: 60 145
			setPri: 4
			ignoreActors: 1
			illegalBits: 0
		)
	)
)

(instance enterprise of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 39
			cel: 0
			posn: 122 107
			setStep: 1 1
			setPri: 6
			setCycle: 0
			ignoreActors: 1
			illegalBits: 0
			cycleSpeed: 1
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look/enterprise') (proc255_0 27 1))
			)
		)
	)
)
