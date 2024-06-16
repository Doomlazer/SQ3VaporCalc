;;; Sierra Script 1.0 - (do not remove this comment)
(script# 47)
(include sci.sh)
(use Main)
(use Class_255_0)
(use AView)
(use Avoid)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room47 0
)

(local
	local0
	gEgoY
	theGGEgoX_5
	local3
)
(instance tin of View
	(properties)
)

(instance rightArm of Prop
	(properties)
)

(instance leftArm of Prop
	(properties)
)

(instance mouth of Prop
	(properties)
)

(instance Room47 of Rm
	(properties
		picture 47
	)
	
	(method (init)
		(= east 48)
		(= west 46)
		(= south 51)
		(= global109 13)
		(= global591 (| global109 (= local3 5)))
		(super init:)
		(= global116 0)
		(tin
			view: 72
			loop: 2
			cel: 0
			ignoreActors:
			posn: 190 66
			setPri: 0
			init:
			addToPic:
		)
		(rightArm
			view: 72
			ignoreActors:
			loop: 0
			cel: 8
			posn: 209 66
			setPri: 0
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		(leftArm
			view: 72
			ignoreActors:
			loop: 1
			cel: 0
			posn: 170 66
			setPri: 0
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		(mouth
			view: 72
			ignoreActors:
			loop: 3
			cel: 1
			posn: 190 56
			setPri: 1
			cycleSpeed: 2
			setCycle: Fwd
			init:
		)
		(if (not global124)
			(leftArm addToPic:)
			(rightArm cel: 5 addToPic:)
			(mouth addToPic:)
		)
		(gEgo init:)
		(proc0_1)
		(switch gNorth
			(43
				(= global104 4)
				(gEgo posn: 192 72 view: 68 setPri: 2 setStep: 1 1)
			)
			(46
				(switch global104
					(4
						(gEgo posn: 1 90 view: 68 setStep: 1 1 setPri: 2)
					)
					(0 (gEgo posn: 1 (gEgo y?)))
					(3
						(gEgo posn: 1 85 looper: (ScriptID 501 1) setPri: 2)
					)
					(1
						(gEgo
							posn: 1 (gEgo y?)
							looper: (ScriptID 501 1)
							setPri: 4
						)
					)
					(2
						(gEgo posn: 1 (gEgo y?) view: 82 setStep: 2 1 setPri: 4)
					)
				)
			)
			(48
				(switch global104
					(0 (gEgo posn: 318 (gEgo y?)))
					(1
						(gEgo
							posn: 318 (gEgo y?)
							looper: (ScriptID 501 1)
							setPri: 4
						)
					)
					(2
						(= global104 4)
						(gEgo
							posn: 318 (gEgo y?)
							view: 68
							setStep: 1 1
							setPri: 2
						)
					)
				)
			)
			(51
				(proc0_1)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x?) 188)
			)
			(else  (gEgo posn: 154 174))
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
			(= gGEgoX_4 124)
			(= gGEgoY_3 147)
			(switch gNorth
				(east (gNewAct posn: 359 172))
				(west (gNewAct posn: -40 172))
				(south (gNewAct posn: 160 249))
				(north (gNewAct posn: 124 147))
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
		(= local0 (gEgo onControl: 0))
		(cond 
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (or (proc501_2 8) (proc501_2 4))
					(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
				)
			)
			((and (== global116 4) (not (& local0 $0004))) (= global116 0) (gEgo ignoreControl: 4))
			((and (== global116 8) (not (& local0 $0008)))
				(= global116 0)
				(if (proc501_2 4)
					(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
				)
			)
			(
			(and (== global116 16) (not (& local0 $0010))) (gEgo ignoreControl: 16) (= global116 0))
		)
		(switch global104
			(0
				(cond 
					(
					(and (& local0 $0002) (not global155) (not global116))
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
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1)
							setMotion: MoveTo theGGEgoX_5 gEgoY
							setPri: 5
						)
					)
					((and (proc501_2 global109) (== global116 0))
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
							setPri: 4
						)
					)
				)
			)
			(1
				(cond 
					(
					(and (& local0 $0004) (not global155) (not global116))
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
							posn: (gEgo x?) (- (gEgo y?) 3)
							observeControl: 4
						)
						(proc0_10)
						(gEgo
							view: 82
							looper: 0
							setStep: 2 1
							observeControl: 4
							setMotion: MoveTo theGGEgoX_5 gEgoY
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
							moveSpeed: 0
						)
					)
					((and (== global116 0) (proc501_2 local3))
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
							setPri: 4
						)
					)
				)
			)
			(2
				(cond 
					(
					(and (& local0 $0008) (not global155) (not global116))
						(= global104 3)
						(= global116 8)
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
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1)
							setMotion: MoveTo theGGEgoX_5 gEgoY
							setPri: 2
						)
					)
					(
					(and (& local0 $0004) (not global155) (not global116))
						(= global116 4)
						(= global104 1)
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
							posn: (gEgo x?) (- (gEgo y?) 3)
							observeControl: 4
						)
						(proc0_10)
						(gEgo
							view: 82
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1)
							setMotion: MoveTo theGGEgoX_5 gEgoY
							setPri: 5
						)
					)
					((and (== global116 0) (proc501_2 local3))
						(= global104 3)
						(= gEgoY 180)
						(= theGGEgoX_5 (gEgo x?))
						(gEgo setPri: 2 posn: (gEgo x?) (+ (gEgo y?) 8))
						(proc0_10)
						(gEgo
							view: 82
							looper: (ScriptID 501 1)
							xStep: 2
							yStep: 1
							setMotion: MoveTo theGGEgoX_5 gEgoY
							setPri: 2
						)
					)
				)
			)
			(3
				(cond 
					(
					(and (& local0 $0010) (not global155) (not global116))
						(= global116 16)
						(= global104 4)
						(if (IsObject (gEgo mover?))
							0
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
						(gEgo posn: (gEgo x?) (- (gEgo y?) 3))
						(proc0_10)
						(gEgo
							view: 68
							looper: 0
							setStep: 1 1
							observeControl: 16
							setMotion: MoveTo theGGEgoX_5 gEgoY
						)
					)
					(
					(and (& local0 $0008) (not global155) (not global116))
						(= global116 8)
						(= global104 2)
						(if (IsObject (gEgo mover?))
							0
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
							view: 82
							looper: 0
							setStep: 1 1
							setPri: 3
							setMotion: MoveTo theGGEgoX_5 gEgoY
						)
					)
					((and (== global116 0) (proc501_2 local3))
						(= gEgoY 180)
						(= theGGEgoX_5 (gEgo x?))
						(gEgo setPri: 2 posn: (gEgo x?) (+ (gEgo y?) 8))
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
			(4
				(cond 
					(
					(and (& local0 $0010) (not global155) (not global116))
						(= global116 16)
						(= global104 3)
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
						(gEgo view: 82 posn: (gEgo x?) (- (gEgo y?) 3))
						(proc0_10)
						(gEgo
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1)
							observeControl: 16
							setMotion: MoveTo theGGEgoX_5 gEgoY
							setPri: 2
						)
					)
					((& local0 $0020) (global2 newRoom: 43))
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 5])
		(if (or (pEvent claimed?) (== global155 1)) (return 1))
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
								(proc255_0 47 0)
							)
							(
								(Said
									'/android,animal,alien,hill,appendage,head,lip,animal'
								)
								(proc255_0 47 1)
							)
						)
					)
				)
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

(instance duneFall of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 76
					looper: 0
					setStep: 5 5
					setLoop: 0
					setAvoider: Avoid
					setPri: 5
					setMotion: MoveTo 204 170 self
				)
			)
			(1
				(proc0_3)
				(gEgo view: 82 setLoop: -1 setAvoider: 0 setStep: 1 1)
				(= global104 2)
				(global2 setScript: 0)
			)
		)
	)
)
