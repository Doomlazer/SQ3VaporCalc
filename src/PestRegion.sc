;;; Sierra Script 1.0 - (do not remove this comment)
(script# 503)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Follow)
(use Chase)
(use Avoid)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	PestRegion 0
)

(local
	local0
	local1
)
(instance guard of Act
	(properties)
)

(instance beam of View
	(properties)
)

(instance blast of Act
	(properties)
)

(instance PestRegion of Rgn
	(properties)
	
	(method (init)
		(super init:)
		(Load rsVIEW 92)
		(Load rsSOUND 44)
	)
	
	(method (doit)
		(super doit:)
		(if (and (== global105 1) (<= (-- global121) 0))
			(= global105 0)
			(= global120 2)
			(gEgo view: 0)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(if (== (pEvent type?) evSAID)
				(cond 
					((Said 'look>')
						(if
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(proc255_0 503 0)
						)
					)
					(
					(or (Said 'turn<on/belt') (Said 'activate/belt'))
						(cond 
							((== global120 2) (proc255_0 503 1))
							((== global120 1) (proc255_0 503 2))
							(else
								(proc255_0 503 3)
								(= global120 1)
								(= global105 1)
								(gEgo view: 123)
							)
						)
					)
					(
					(or (Said 'turn<off/belt') (Said 'deactivate/belt'))
						(cond 
							((== global120 2) (proc255_0 503 4))
							((== global120 0) (proc255_0 503 5))
							(else
								(proc255_0 503 3)
								(= global105 0)
								(= global120 1)
								(gEgo view: 0)
							)
						)
					)
					((Said 'converse/guard') (= gSeconds 3) (self notify:))
				)
			else
				0
			)
		)
	)
	
	(method (notify)
		(self setScript: guardActions)
	)
)

(instance guardActions of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== global122 2) (== global105 1) (>= state 2))
			(proc255_0 503 6)
			(= global122 4)
			(guard setMotion: 0)
		)
		(if (and (== global122 4) (== global105 0))
			(= global122 2)
			(= state 1)
			(guard setMotion: Chase gEgo 250)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 503 7)
				(= seconds gSeconds)
			)
			(1
				(= global122 2)
				(= local1 (Random (- (gEgo y?) 20) (+ (gEgo y?) 20)))
				(if (< (gEgo y?) (+ (global2 horizon?) 2))
					(= local1 (+ (global2 horizon?) 2))
				)
				(if (< (Random 1 10000) 5000)
					(= local0 326)
				else
					(= local0 -7)
				)
				(guard
					view: 593
					setCycle: Walk
					illegalBits: -32768
					setAvoider: Avoid
					posn: local0 local1
					setMotion: Chase gEgo 250 self
					init:
				)
			)
			(2
				(cond 
					((or (< (guard x?) 3) (> (guard x?) 316))
						(-- state)
						(guard setMotion: Follow gEgo 5)
						(= seconds 1)
					)
					((and (!= global122 4) (== global105 0))
						(proc255_0 503 8)
						(guard
							setMotion: 0
							setLoop: (if (== (guard loop?) 0) 2 else 3)
							cel: 255
							setCycle: End self
						)
					)
				)
			)
			(3
				(gLongSong number: 44 loop: 1 priority: 2 play:)
				(guard
					setLoop: (if (== (guard loop?) 2) 4 else 5)
					cel: 255
					setCycle: End self
				)
			)
			(4
				(proc0_2)
				(blast
					view: 593
					setLoop: (if (== (guard loop?) 0) 6 else 7)
					cel: 255
					setCycle: End
					setStep: 30 10
					ignoreActors:
					illegalBits: 0
					setPri: (gEgo priority?)
					x: (if (== (guard loop?) 4)
						(+ (guard x?) 3)
					else
						(- (guard x?) 3)
					)
					y: (- (guard y?) 16)
					init:
				)
				(proc0_10)
				(blast
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 18) self
				)
			)
			(5
				(blast dispose:)
				(gEgo view: 92 setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(6 (proc0_17 901 0 7 999))
		)
	)
)
