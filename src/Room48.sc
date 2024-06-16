;;; Sierra Script 1.0 - (do not remove this comment)
(script# 48)
(include sci.sh)
(use Main)
(use Class_255_0)
(use AView)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room48 0
)

(local
	local0
	gEgoY
	theGGEgoX_5
)
(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room48 of Rm
	(properties
		picture 48
	)
	
	(method (init)
		(= north 44)
		(= west 47)
		(= east 45)
		(= south 52)
		(= global591 (= global109 5))
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(= global116 0)
		(gEgo init:)
		(lightning
			view: 69
			loop: 0
			cel: 0
			posn: 80 10
			setScript: flash
			init:
		)
		(switch gNorth
			(north
				(= global104 2)
				(gEgo
					posn: 112 86
					view: 68
					looper: 0
					setPri: 2
					ignoreControl: 8192
				)
			)
			(south
				(= global104 0)
				(proc0_1)
				(gEgo
					posn: (gEgo x?) 188
					view: 0
					looper: 0
					setPri: -1
					observeControl: 8192
				)
			)
			(west
				(switch global104
					(0
						(gEgo
							posn: 1 (gEgo y?)
							setStep: 3 2
							observeControl: 8192
							setPri: -1
						)
					)
					(1
						(gEgo
							posn: 1 122
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							looper: (ScriptID 501 1)
							setPri: 2
						)
					)
					(3
						(= global104 1)
						(gEgo
							posn: 1 122
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							looper: (ScriptID 501 1)
							setPri: 2
						)
					)
					(2
						(= global104 1)
						(gEgo
							posn: 1 122
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							looper: (ScriptID 501 1)
							setPri: 2
						)
					)
					(4
						(= global104 2)
						(gEgo
							view: 68
							posn: 1 98
							looper: 0
							ignoreControl: 8192
							setStep: 1 1
							setPri: 2
						)
					)
				)
			)
			(east
				(switch global104
					(0
						(proc0_1)
						(gEgo
							posn: 318 (gEgo y?)
							observeControl: 8192
							setStep: 3 2
						)
					)
					(1
						(gEgo
							posn: 318 111
							setPri: 2
							setStep: 2 1
							looper: (ScriptID 501 1)
						)
					)
					(2
						(gEgo
							view: 68
							posn: 318 89
							looper: 0
							setStep: 1 1
							setPri: 2
						)
					)
				)
			)
			(else 
				(gEgo view: 0 posn: 160 160)
			)
		)
		(self setRegions: 501)
		(switch global110
			(1
				(if (== (Random 1 3) 2)
					((= gNewAct (Act new:)) posn: 1000 1000 init:)
					(= gSeconds (Random 2 10))
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
			(= gGEgoX_4 47)
			(= gGEgoY_3 109)
			(switch gNorth
				(east (gNewAct posn: 359 150))
				(west (gNewAct posn: -40 150))
				(south (gNewAct posn: 213 249))
				(north (gNewAct posn: 47 109))
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1)
		else
			((ScriptID 501 0) notify: 4)
		)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(cond 
			((& (= local0 (gEgo onControl: 0)) $0008) (global2 newRoom: 44))
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (proc501_2 4)
					(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
				)
			)
			((and (== global116 4) (not (& local0 $0004))) (gEgo ignoreControl: 4) (= global116 0))
			(
				(and
					(& local0 $0002)
					(== global104 0)
					(not global155)
					(not global116)
				)
				(= global104 1)
				(= global116 2)
				(= gGEgoX_4 (gEgo x?))
				(= gGEgoY_3 (gEgo y?))
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY 400)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= theGGEgoX_5 ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= theGGEgoX_5 (gEgo x?))
				)
				(gEgo
					view: 82
					looper: (ScriptID 501 1)
					xStep: 2
					yStep: 1
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: 4
					ignoreControl: 8192
				)
			)
			(
				(and
					(& local0 $0002)
					(== global104 1)
					(not global155)
					(not global116)
				)
				(= global116 2)
				(= global104 0)
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= theGGEgoX_5 ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= theGGEgoX_5 (gEgo x?))
				)
				(gEgo
					view: 0
					xStep: 3
					yStep: 2
					looper: 0
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: -1
					observeControl: 8192
					moveSpeed: 0
				)
			)
			(
				(and
					(== global104 1)
					(& local0 $0004)
					(not global155)
					(not global116)
				)
				(= global116 4)
				(= global104 2)
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= theGGEgoX_5 ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= theGGEgoX_5 (gEgo x?))
				)
				(gEgo
					view: 68
					posn: (gEgo x?) (- (gEgo y?) 3)
					observeControl: 4
				)
				(proc0_10)
				(gEgo
					view: 68
					looper: 0
					setStep: 1 1
					setPri: 4
					setMotion: MoveTo theGGEgoX_5 gEgoY
				)
			)
			(
				(and
					(== global104 2)
					(& local0 $0004)
					(not global155)
					(not global116)
				)
				(= global104 1)
				(= global116 4)
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY -400)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= theGGEgoX_5 ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= theGGEgoX_5 (gEgo x?))
				)
				(gEgo
					view: 82
					posn: (gEgo x?) (- (gEgo y?) 3)
					observeControl: 4
				)
				(proc0_10)
				(gEgo
					looper: (ScriptID 501 1)
					xStep: 2
					yStep: 1
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: 4
					ignoreControl: 8192
				)
			)
			(
				(and
					(!= global104 2)
					(== global116 0)
					(or (proc501_2 global109) (< (gEgo y?) 85))
				)
				(= global104 1)
				(= gEgoY 180)
				(= theGGEgoX_5 (gEgo x?))
				(gEgo setPri: 3 posn: (gEgo x?) (+ (gEgo y?) 8))
				(proc0_10)
				(gEgo
					view: 82
					looper: (ScriptID 501 1)
					xStep: 2
					yStep: 1
					setMotion: MoveTo theGGEgoX_5 gEgoY
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 5])
		(if (pEvent claimed?) (return 1))
		(return
			(switch (pEvent type?)
				(evSAID
					(if (Said 'look>')
						(cond 
							(
								(or
									(Said '/area')
									(Said '/around')
									(Said '[<around][/!*]')
								)
								(proc255_0 48 0)
							)
							((Said '/rock') (proc255_0 48 1))
							((Said '/cavity') (proc255_0 48 2))
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(DisposeScript 988)
		(proc0_1)
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
			(4 (= state -1) (= cycles 2))
		)
	)
)
