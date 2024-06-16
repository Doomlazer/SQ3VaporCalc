;;; Sierra Script 1.0 - (do not remove this comment)
(script# 45)
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
	Room45 0
)

(local
	local0
	gEgoY
	gEgoX
)
(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room45 of Rm
	(properties
		picture 45
	)
	
	(method (init)
		(= north 41)
		(= west 48)
		(= south 49)
		(= east 46)
		(= global591 (= global109 17))
		(self setRegions: 501)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(= global116 0)
		(gEgo init:)
		(lightning
			view: 69
			loop: 4
			cel: 0
			posn: 218 54
			setScript: flash
			init:
		)
		(switch gNorth
			(41
				(= global104 2)
				(gEgo
					posn: 165 55
					view: 68
					setPri: 4
					looper: 0
					setStep: 1 1
				)
			)
			(49
				(= global104 0)
				(gEgo view: 0)
				(gEgo posn: (gEgo x?) 188)
			)
			(46
				(switch global104
					(0
						(gEgo posn: 318 (gEgo y?) setStep: 3 2 setPri: -1)
					)
					(3
						(= global104 1)
						(gEgo
							posn: 318 100
							setPri: 4
							setStep: 2 1
							looper: (ScriptID 501 1)
							ignoreControl: 8192
						)
					)
					(4
						(= global104 2)
						(gEgo
							view: 68
							posn: 318 80
							looper: 0
							setStep: 1 1
							setPri: 4
						)
					)
				)
			)
			(48
				(switch global104
					(0
						(proc0_1)
						(gEgo view: 0 posn: 1 (gEgo y?))
					)
					(1
						(gEgo
							posn: 1 111
							setPri: 4
							setStep: 2 1
							looper: (ScriptID 501 1)
							ignoreControl: 8192
						)
					)
					(2
						(gEgo
							view: 68
							posn: 1 89
							looper: 0
							setStep: 1 1
							setPri: 4
						)
					)
				)
			)
			(else 
				(gEgo view: 0 posn: 160 160)
			)
		)
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
				hide:
				init:
			)
			(= gGEgoX_4 113)
			(= gGEgoY_3 113)
			(switch gNorth
				(east (gNewAct posn: 359 140))
				(west (gNewAct posn: -40 140))
				(south (gNewAct posn: 160 249))
				(north (gNewAct posn: 113 113))
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
			((& (= local0 (gEgo onControl: 0)) $0008) (global2 newRoom: 41))
			(
				(and
					(== global116 2)
					(not global155)
					(not (& local0 $0002))
				)
				(= global116 0)
				(if (proc501_2 16)
					(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
				)
			)
			(
				(and
					(== global116 4)
					(not global155)
					(not (& local0 $0004))
				)
				(= global116 0)
				(gEgo ignoreControl: 4)
			)
			(
				(and
					(& local0 $0002)
					(not global155)
					(== global104 0)
					(not global116)
				)
				(= global104 1)
				(= gGEgoX_4 (gEgo x?))
				(= gGEgoY_3 (gEgo y?))
				(= global116 2)
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY 400)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= gEgoX ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= gEgoX (gEgo x?))
				)
				(gEgo
					view: 82
					looper: (ScriptID 501 1)
					xStep: 2
					yStep: 1
					setMotion: MoveTo gEgoX gEgoY
					setPri: 4
					ignoreControl: 8192
				)
			)
			(
				(and
					(& local0 $0002)
					(not global155)
					(== global104 1)
					(not global116)
				)
				(= global104 0)
				(= global116 2)
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= gEgoX gGEgoX_5)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= gEgoX ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= gEgoX (gEgo x?))
				)
				(gEgo
					view: 0
					xStep: 3
					yStep: 2
					looper: 0
					setMotion: MoveTo gEgoX gEgoY
					setPri: -1
					observeControl: 8192
					moveSpeed: 0
				)
			)
			(
				(and
					(== global104 1)
					(not global155)
					(& local0 $0004)
					(not global116)
				)
				(= global116 4)
				(= global104 2)
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= gEgoX gGEgoX_5)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= gEgoX ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= gEgoX (gEgo x?))
				)
				(gEgo
					view: 68
					posn: (gEgo x?) (- (gEgo y?) 3)
					observeControl: 4
				)
				(proc0_10)
				(gEgo
					setStep: 1 1
					looper: 0
					setPri: 4
					setMotion: MoveTo gEgoX gEgoY
				)
			)
			(
				(and
					(== global104 2)
					(not global155)
					(& local0 $0004)
					(not global116)
				)
				(= global104 1)
				(= global116 4)
				(if (IsObject (gEgo mover?))
					(if gGEgoY_4
						(= gEgoY -400)
						(= gEgoX gGEgoX_5)
					else
						(= gEgoY
							(+ (- (gEgo y?) ((gEgo mover?) y?)) (gEgo y?))
						)
						(= gEgoX ((gEgo mover?) x?))
					)
				else
					(= gEgoY (gEgo y?))
					(= gEgoX (gEgo x?))
				)
				(gEgo
					view: 82
					posn: (gEgo x?) (- (gEgo y?) 3)
					observeControl: 4
				)
				(proc0_10)
				(gEgo
					view: 82
					looper: (ScriptID 501 1)
					xStep: 2
					yStep: 1
					setMotion: MoveTo gEgoX gEgoY
					setPri: 4
					ignoreControl: 8192
				)
			)
			(
				(and
					(!= global104 2)
					(== global116 0)
					(proc501_2 global109)
				)
				(= global104 1)
				(= gEgoY 180)
				(= gEgoX (gEgo x?))
				(gEgo setPri: 4 posn: (gEgo x?) (+ (gEgo y?) 8))
				(proc0_10)
				(gEgo
					view: 82
					looper: (ScriptID 501 1)
					xStep: 4
					yStep: 1
					setMotion: MoveTo gEgoX gEgoY
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 5])
		(if (pEvent claimed?) (return 1))
		(return
			(switch (pEvent type?)
				(evSAID
					(if
						(and
							(Said 'look>')
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
						)
						(proc255_0 45 0)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(proc0_1)
		(DisposeScript 988)
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
