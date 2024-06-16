;;; Sierra Script 1.0 - (do not remove this comment)
(script# 44)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room44 0
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room44 of Rm
	(properties
		picture 44
	)
	
	(method (init)
		(= east 41)
		(= south 48)
		(= west 43)
		(= north 54)
		(= horizon 85)
		(= global591 0)
		(= global109 0)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(lightning
			view: 69
			loop: 6
			cel: 0
			posn: 291 59
			setScript: flash
			init:
		)
		(proc0_1)
		(gEgo looper: 0)
		(switch gNorth
			(48
				(proc0_1)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x?) 188 setStep: 3 2)
			)
			(43 (gEgo posn: 1 (gEgo y?)))
			(41
				(if (< (gEgo y?) (+ horizon 2))
					(gEgo posn: 318 (+ horizon 2))
				else
					(gEgo posn: 318 (gEgo y?))
				)
			)
			(54
				(gEgo
					view: 0
					posn: (gEgo x?) (+ horizon 2)
					setStep: 3 2
				)
			)
			(else  (gEgo view: 0))
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
					(gNewAct posn: 120 (+ horizon 2))
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
			(if (== (pEvent type?) evSAID)
				(cond 
					((Said 'read/sign')
						(if (== (gEgo onControl: 1) 8192)
							(if (or (== (gEgo loop?) 1) (== (gEgo loop?) 3))
								(proc255_0 44 0)
							else
								(proc255_0 44 1)
							)
						else
							(proc255_0 44 2)
						)
					)
					((Said 'look/sign') (proc255_0 44 3))
					(
						(and
							(Said 'look>')
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
						)
						(proc255_0 44 4)
					)
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

(instance flash of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 8 30)))
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
