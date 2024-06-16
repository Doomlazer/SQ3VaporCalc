;;; Sierra Script 1.0 - (do not remove this comment)
(script# 85)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room85 0
)

(local
	local0
	local1
	theGuard
)
(instance guard of Prop
	(properties)
)

(instance guard2 of Prop
	(properties)
)

(instance force of View
	(properties)
)

(instance blast of Act
	(properties)
)

(instance Room85 of Rm
	(properties
		picture 85
	)
	
	(method (init)
		(= north (= west (= south 80)))
		(Load rsVIEW 123)
		(Load rsVIEW 593)
		(Load rsVIEW 134)
		(Load rsVIEW 92)
		(super init:)
		(proc0_1)
		(guard view: 124 loop: 4 cel: 0 posn: 132 153 init:)
		(guard2 view: 124 loop: 4 cel: 0 posn: 221 122 init:)
		(switch gNorth
			(81
				(proc0_2)
				(gEgo view: 0 posn: 324 166 init:)
				(global2 setScript: Actions)
			)
			(86
				(proc0_2)
				(gEgo view: 0 posn: 123 169 setPri: 4 init:)
				(global2 setScript: Actions)
				(Actions changeState: 2)
			)
		)
		(if (gEgo has: 12) (gEgo view: 113))
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if (== (Actions state?) 1)
			(if
				(and
					(not global155)
					(or
						(> (gEgo x?) 313)
						(and (> (gEgo y?) 186) (> (gEgo x?) 174))
					)
					(== (gEgo script?) 0)
				)
				(gEgo setScript: turnVisible)
			)
			(= local0 (gEgo onControl: 0))
			(-- global121)
			(if
			(and (== global120 1) (not global155) (<= global121 0))
				(gEgo setScript: turnVisible)
				(= global120 2)
			)
			(cond 
				((& local0 $0004) (Actions changeState: 5))
				((& local0 $1000) (Actions changeState: 6))
				((& local0 $2000) (Actions changeState: 7))
				((& local0 $0040) (global2 setScript: walkDown))
			)
			(if (== global105 0) (Actions changeState: 8))
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
								(proc255_0 85 0)
							)
							((Said '/guard') (proc255_0 85 1))
							((Said '/beam') (proc255_0 85 2))
							(else (proc255_0 85 3) (pEvent claimed: 1))
						)
					)
					(
					(or (Said 'turn<off/belt') (Said 'deactivate/belt')) (proc255_0 85 4))
					(
						(or
							(Said 'attack,beat,converse,kiss/guard,man,flunky')
							(Said 'get/gun')
						)
						(proc255_0 85 5)
					)
					((Said 'turn<off/beam') (proc255_0 85 6))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (and (>= (gEgo y?) 189) (<= (gEgo x?) 188))
			(++ local1)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance Actions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global120 1) (gEgo view: 123))
				(gEgo setMotion: MoveTo 303 166 self)
			)
			(1
				(proc0_3)
				(global2 east: 80)
			)
			(2
				(gEgo
					setLoop: 0
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 159 129 self
				)
			)
			(3
				(gEgo setPri: -1 setMotion: MoveTo 204 150 self)
			)
			(4
				(proc0_1)
				(self changeState: 1)
			)
			(5
				(proc0_2)
				(force
					view: 124
					setLoop: 1
					setCel: 0
					setPri: 1
					ignoreActors:
					posn: 253 116
					init:
					addToPic:
				)
				(gEgo view: 124 setLoop: 3 setCycle: Fwd)
				(= state 13)
				(= seconds 7)
			)
			(6
				(proc0_2)
				(force
					view: 124
					setLoop: 1
					setCel: 1
					setPri: 12
					ignoreActors:
					posn: 75 174
					init:
					addToPic:
				)
				(gEgo view: 124 setLoop: 3 setCycle: Fwd)
				(= state 13)
				(= seconds 7)
			)
			(7
				(proc0_2)
				(force
					view: 124
					setLoop: 1
					setCel: 2
					setPri: 14
					ignoreActors:
					posn: 99 187
					init:
					addToPic:
				)
				(gEgo view: 124 setLoop: 2 setCycle: Fwd)
				(= state 13)
				(= seconds 7)
			)
			(8
				(= seconds 1)
				(gEgo view: (if (gEgo has: 12) 113 else 0) loop: 2)
			)
			(9
				(proc0_2)
				(proc0_10)
				(gLongSong number: 44 loop: 1 priority: 2 play:)
				(cond 
					((gEgo inRect: 24 41 125 184)
						(guard setLoop: 5 cel: 0 setCycle: End self)
						(= theGuard guard)
					)
					((> (gEgo y?) 142) (guard setCycle: End self) (= theGuard guard))
					((gEgo inRect: 107 118 209 147)
						(guard2 setLoop: 5 cel: 0 setCycle: End self)
						(= theGuard guard2)
					)
					(else (guard2 setCycle: End self) (= theGuard guard2))
				)
			)
			(10
				(proc0_2)
				(blast
					view: 593
					setLoop: (if (== (theGuard loop?) 4) 6 else 7)
					cel: 0
					setCycle: End
					setStep: 30 10
					ignoreActors:
					illegalBits: 0
					setPri: (gEgo priority?)
					x:
						(if (== (theGuard loop?) 4)
							(+ (theGuard x?) 30)
						else
							(- (theGuard x?) 30)
						)
					y: (- (theGuard y?) 18)
					init:
				)
				(proc0_10)
				(blast
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 18) self
				)
			)
			(11
				(blast dispose:)
				(gEgo
					setLoop: (if (gEgo has: 12) 5 else 2)
					view: 92
					cel: 0
					setCycle: Fwd
				)
				(= seconds 7)
			)
			(12 (proc0_17 901 0 7 99))
			(14
				(proc255_0 85 7)
				(self changeState: 16)
			)
			(16 (proc0_17 901 0 11 18))
		)
	)
)

(instance turnVisible of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: 0 view: 134 setLoop: 4 setCycle: Fwd)
				(proc0_10)
				(= seconds 2)
			)
			(1
				(proc255_0 85 8)
				(gEgo setLoop: 3)
				(= seconds 2)
			)
			(2
				(proc255_0 85 9)
				(gEgo setLoop: 1)
				(= seconds 3)
			)
			(3
				(gEgo setCycle: 0 setCel: 0)
				(= global105 0)
			)
		)
	)
)

(instance walkDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setPri: 4
					setLoop: 1
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 123 169 self
				)
			)
			(1 (global2 newRoom: 86))
		)
	)
)
