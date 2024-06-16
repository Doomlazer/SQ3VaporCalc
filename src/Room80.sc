;;; Sierra Script 1.0 - (do not remove this comment)
(script# 80)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Obj)

(public
	Room80 0
)

(instance Room80 of Rm
	(properties
		picture 80
	)
	
	(method (init)
		(= north (= west (= south (= east 81))))
		(= horizon 55)
		(super init:)
		(proc0_1)
		(gEgo view: 63)
		(switch gNorth
			(14
				(gEgo posn: 180 135 init:)
				(global2 setScript: Actions)
			)
			(81
				(gEgo posn: gGEgoX_4 gGEgoY_3 loop: gGEgoX_5)
			)
			(85
				(if (== global105 1) (gEgo view: 123))
				(gEgo posn: 1 144)
				(= gSeconds 5)
				((ScriptID 503) notify:)
			)
			(else 
				(gEgo view: 0 posn: 160 188)
			)
		)
		(gEgo init:)
		(if (== global105 1) (proc255_0 80 0) (= global105 0))
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
			(and
				(& (gEgo onControl: 0) $0040)
				(== (global2 script?) 0)
			)
			(global2 newRoom: 14)
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
								(proc255_0 80 1)
							)
							((Said '/tree') (proc255_0 80 2))
							((Said '/rock,banner,boulder') (proc255_0 80 3))
							((Said '/craft') (proc255_0 80 4))
							((or (Said '<up') (Said '/air')) (proc255_0 80 5))
							((or (Said '<down') (Said '/dirt,pass')) (proc255_0 80 6))
						)
					)
					((Said 'get,get/rock,banner') (proc255_0 80 7))
					((Said 'climb/tree') (proc255_0 80 8))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(cond 
			((> (gEgo x?) 317) (= gGEgoX_4 317) (= gGEgoY_3 (gEgo y?)) (= gGEgoX_5 1))
			((> (gEgo y?) 187) (= gGEgoY_3 186) (= gGEgoX_4 (gEgo x?)) (= gGEgoX_5 3))
			((< (gEgo x?) 2) (= gGEgoX_4 3) (= gGEgoY_3 (gEgo y?)) (= gGEgoX_5 0))
			(else
				(= gGEgoX_4 (gEgo x?))
				(= gGEgoY_3 (+ horizon 3))
				(= gGEgoX_5 2)
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance Actions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 202 160 self)
			)
			(1
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)
