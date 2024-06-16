;;; Sierra Script 1.0 - (do not remove this comment)
(script# 51)
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
	Room51 0
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

(instance Room51 of Rm
	(properties
		picture 51
	)
	
	(method (init)
		(= north 47)
		(= west 50)
		(= east 52)
		(= south 53)
		(= horizon 70)
		(= global109 1)
		(= global591 1)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(= global116 0)
		(proc0_1)
		(gEgo view: 0 init:)
		(lightning
			view: 69
			loop: 4
			cel: 0
			posn: 114 53
			setScript: flash
			init:
		)
		(switch gNorth
			(47
				(= global104 2)
				(gEgo
					posn: 145 (+ horizon 2)
					setPri: 1
					view: 68
					looper: 0
					setStep: 1 1
					illegalBits: 0
				)
			)
			(50
				(switch global104
					(0
						(if (< (gEgo y?) 85)
							(gEgo
								posn: 1 90
								setPri: -1
								setStep: 3 2
								observeControl: 8192
							)
						else
							(gEgo
								posn: 1 (gEgo y?)
								setStep: 3 2
								setPri: -1
								observeControl: 8192
							)
						)
					)
					(1
						(gEgo
							view: 82
							looper: (ScriptID 501 1)
							posn: 1 108
							setPri: 1
							setStep: 1 1
							ignoreControl: 8192
						)
					)
					(2
						(gEgo
							view: 68
							posn: 1 80
							setStep: 1 1
							setPri: 1
							ignoreControl: 8192
						)
					)
				)
			)
			(52
				(switch global104
					(0
						(proc0_1)
						(gEgo view: 0 observeControl: 8192 posn: 318 (gEgo y?))
					)
					(1
						(gEgo
							view: 82
							ignoreControl: 8192
							posn: 318 119
							setStep: 1 1
							looper: (ScriptID 501 1)
							setPri: 1
						)
					)
					(2
						(gEgo
							view: 68
							posn: 318 80
							setStep: 1 1
							setPri: 1
							ignoreControl: 8192
						)
					)
				)
			)
			(53
				(proc0_1)
				(gEgo view: 0 posn: (gEgo x?) 188 observeControl: 8192)
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
				observeControl: 2 8192
				posn: 1000 1000
				init:
			)
			(= gGEgoX_4 127)
			(= gGEgoY_3 103)
			(switch gNorth
				(east (gNewAct posn: 359 135))
				(west (gNewAct posn: -40 116))
				(south (gNewAct posn: 190 249))
				(north (gNewAct posn: 127 103))
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1)
		else
			((ScriptID 501 0) notify: 4)
		)
		(global2 setScript: Actions)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(= local0 (gEgo onControl: 0))
		(cond 
			((and (== global116 2) (not (& local0 $0002)))
				(if (proc501_2 1)
					(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
				)
				(= global116 0)
			)
			((and (== global116 4) (not (& local0 $0004))) (= global116 0) (gEgo ignoreControl: 4))
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
					setStep: 2 1
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: 1
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
				(= global104 0)
				(= global116 2)
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
					setStep: 3 2
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: -1
					observeControl: 8192
					looper: 0
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
				(gEgo view: 68 posn: (gEgo x?) (- (gEgo y?) 2))
				(proc0_10)
				(gEgo
					view: 68
					setStep: 1 1
					looper: 0
					illegalBits: 0
					observeControl: 4
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
					view: 82
					posn: (gEgo x?) (- (gEgo y?) 2)
					observeControl: 4
				)
				(proc0_10)
				(gEgo
					looper: (ScriptID 501 1)
					setStep: 2 1
					illegalBits: -32768
					ignoreControl: 8192
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: 1
				)
			)
			(
				(and
					(!= global104 2)
					(== global116 0)
					(or
						(proc501_2 global109)
						(and
							(> (gEgo x?) 146)
							(< (gEgo x?) 179)
							(< (gEgo y?) 96)
						)
						(< (gEgo y?) 81)
					)
				)
				(= global104 1)
				(= gEgoY 180)
				(= theGGEgoX_5 (gEgo x?))
				(gEgo setPri: 2 posn: (gEgo x?) (+ (gEgo y?) 8))
				(proc0_10)
				(gEgo
					posn: (gEgo x?) (+ (gEgo y?) 8)
					view: 82
					looper: (ScriptID 501 1)
					setStep: 2 1
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
								(proc255_0 51 0)
							)
							((Said '/cavity') (proc255_0 51 1))
							((Said '/rock') (proc255_0 51 2))
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not global155)
			(proc0_1)
			(DisposeScript 988)
			(if
				(and
					(gCast contains: gNewAct)
					(< (gEgo distanceTo: gNewAct) 120)
				)
				(= global110 2)
			)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance Actions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(else )
		)
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
