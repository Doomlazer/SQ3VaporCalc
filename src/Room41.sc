;;; Sierra Script 1.0 - (do not remove this comment)
(script# 41)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)

(public
	Room41 0
)

(instance Room41 of Rm
	(properties
		picture 41
	)
	
	(method (init)
		(= east 42)
		(= south 45)
		(= west 44)
		(= north 54)
		(= horizon 85)
		(super init:)
		(= global109 0)
		(= global591 0)
		(gEgo init:)
		(switch gNorth
			(54
				(proc0_1)
				(gEgo view: 0 posn: (gEgo x?) (+ horizon 2))
			)
			(45
				(proc0_1)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x?) 188)
			)
			(42
				(proc0_1)
				(gEgo view: 0 posn: 318 (gEgo y?))
			)
			(44
				(proc0_1)
				(gEgo view: 0 posn: 1 (gEgo y?))
			)
			(else 
				(gEgo view: 0 posn: 160 188)
			)
		)
		(gEgo init:)
		(self setRegions: 501)
		(switch global110
			(1
				(if (== (Random 1 4) 3)
					((= gNewAct (Act new:)) posn: 1000 1000 init:)
					(= gSeconds (Random 2 12))
				)
			)
			(2
				((= gNewAct (Act new:)) posn: 1000 1000 init:)
				(= gSeconds 3)
			)
		)
		(if (gCast contains: gNewAct)
			(gNewAct
				view: 106
				setCycle: Walk
				observeControl: 2
				posn: 1000 1000
				init:
			)
			(switch gNorth
				(east (gNewAct posn: 359 130))
				(west (gNewAct posn: -40 130))
				(south (gNewAct posn: 160 249))
				(north
					(gNewAct posn: 160 (+ horizon 2))
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1)
		else
			((ScriptID 501 0) notify: 4)
		)
	)
	
	(method (doit)
		(super doit:)
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
						(proc255_0 41 0)
					)
					((Said '/dune') (proc255_0 41 1))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if
			(and
				(gCast contains: gNewAct)
				(< (gEgo distanceTo: gNewAct) 120)
			)
			(= global110 2)
		)
		(if (not global155) (super newRoom: newRoomNumber))
	)
)
