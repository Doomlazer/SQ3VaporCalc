;;; Sierra Script 1.0 - (do not remove this comment)
(script# 46)
(include sci.sh)
(use Main)
(use Class_255_0)
(use AView)
(use Avoid)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room46 0
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

(instance Room46 of Rm
	(properties
		picture 46
	)
	
	(method (init)
		(= east 47)
		(= west 45)
		(= north 42)
		(= south 50)
		(Load rsVIEW 76)
		(= global591 (= global109 9))
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(Load rsVIEW 76)
		(super init:)
		(= global116 0)
		(proc0_1)
		(gEgo view: 0 observeControl: 8192 init:)
		(lightning
			view: 69
			loop: 4
			cel: 0
			posn: 14 52
			ignoreActors:
			setScript: flash
			init:
		)
		(switch gNorth
			(42
				(= global104 4)
				(gEgo
					posn: 120 60
					view: 68
					ignoreControl: 8192 2048
					setPri: 3
					setStep: 1 1
				)
			)
			(45
				(switch global104
					(0
						(gEgo posn: 1 (gEgo y?) setPri: -1 view: 0)
					)
					(1
						(= global104 3)
						(gEgo
							posn: 1 97
							setPri: 3
							ignoreControl: 8192
							looper: (ScriptID 501 1)
							view: 82
						)
					)
					(2
						(= global104 4)
						(gEgo
							posn: 1 75
							ignoreControl: 8192
							setStep: 1 1
							setPri: 3
							view: 68
						)
					)
				)
			)
			(47
				(switch global104
					(0
						(gEgo view: 0)
						(gEgo posn: 318 (gEgo y?))
					)
					(1
						(gEgo
							posn: 318 158
							view: 82
							looper: (ScriptID 501 1)
							ignoreControl: 8192
							setStep: 2 1
							setPri: 5
						)
					)
					(2
						(= global104 2)
						(gEgo view: 82 ignoreControl: 8192 2048 setPri: 5)
						(if (< (gEgo y?) 107)
							(gEgo posn: 318 110)
						else
							(gEgo posn: 318 (gEgo y?))
						)
					)
					(3
						(gEgo
							posn: 318 80
							view: 82
							looper: (ScriptID 501 1)
							ignoreControl: 8192
							observeControl: 2048
							setStep: 2 1
							setPri: 3
						)
					)
					(4
						(gEgo
							posn: 318 61
							view: 68
							ignoreControl: 8192
							setPri: 3
							setStep: 1 1
						)
					)
				)
			)
			(50
				(= global104 0)
				(proc0_1)
				(gEgo posn: (gEgo x?) 188 ignoreControl: 2048 view: 0)
			)
			(else 
				(gEgo posn: 154 174 observeControl: 1024)
			)
		)
		(self setRegions: 501)
		(if (gCast contains: gNewAct)
			(gNewAct
				view: 106
				setCycle: Walk
				observeControl: 2
				observeControl: 8192 16 16384
				posn: 1000 1000
				init:
			)
			(= gGEgoX_4 23)
			(= gGEgoY_3 90)
			(switch gNorth
				(east (gNewAct posn: 359 175))
				(west (gNewAct posn: -40 175))
				(south (gNewAct posn: 160 249))
				(north (gNewAct posn: 23 90))
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
		(if
			(and
				(!= (self script?) duneFall)
				(or
					(and
						(& local0 $0008)
						(or (== global104 1) (== global104 2))
					)
					(and (& local0 $4000) (== global104 0))
				)
			)
			(proc0_2)
			(self setScript: duneFall)
		)
		(if (!= (global2 script?) duneFall)
			(cond 
				((& local0 $0100) (global2 newRoom: 42))
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
				)
				(
					(and
						(== global116 16)
						(not global155)
						(not (& local0 $0010))
					)
					(= global116 0)
					(if (proc501_2 8)
						(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
					)
				)
				(
					(and
						(== global116 32)
						(not global155)
						(not (& local0 $0020))
					)
					(= global116 0)
				)
				(
					(and
						(& local0 $0002)
						(== global104 0)
						(not global155)
						(not global116)
					)
					(= global116 2)
					(= global104 1)
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
						observeControl: 2048
						setMotion: MoveTo theGGEgoX_5 gEgoY
						setPri: 5
					)
				)
				(
					(and
						(& local0 $0010)
						(== global104 0)
						(not global155)
						(not global116)
					)
					(= global104 3)
					(= global116 16)
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
						ignoreControl: 8192
						observeControl: 2048
						looper: (ScriptID 501 1)
						setMotion: MoveTo theGGEgoX_5 gEgoY
						setPri: 3
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
						observeControl: 8192
						ignoreControl: 2048
						setMotion: MoveTo theGGEgoX_5 gEgoY
						setPri: -1
						moveSpeed: 0
					)
				)
				(
					(and
						(& local0 $0010)
						(== global104 3)
						(not global155)
						(not global116)
					)
					(= global116 16)
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
						ignoreControl: 2048
						observeControl: 8192
						setMotion: MoveTo theGGEgoX_5 gEgoY
						setPri: -1
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
						view: 82
						looper: 0
						setPri: 5
						posn: (gEgo x?) (- (gEgo y?) 3)
						observeControl: 8192 2048
						setStep: 2 1
						setMotion: MoveTo theGGEgoX_5 gEgoY
					)
				)
				(
					(and
						(== global104 3)
						(& local0 $0020)
						(not global155)
						(not global116)
					)
					(= global116 32)
					(= global104 4)
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
						looper: 0
						setStep: 1 1
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
						xStep: 2
						yStep: 1
						posn: (gEgo x?) (- (gEgo y?) 3)
						looper: (ScriptID 501 1)
						ignoreControl: 8192
						observeControl: 2048
						setMotion: MoveTo theGGEgoX_5 gEgoY
						setPri: 5
					)
				)
				(
					(and
						(== global104 4)
						(& local0 $0020)
						(not global155)
						(not global116)
					)
					(= global116 32)
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
					(gEgo
						view: 82
						xStep: 2
						yStep: 1
						posn: (gEgo x?) (- (gEgo y?) 3)
						looper: (ScriptID 501 1)
						ignoreControl: 8192
						observeControl: 2048
						setMotion: MoveTo theGGEgoX_5 gEgoY
						setPri: 3
					)
				)
				(
					(and
						(or (== global104 0) (== global104 3))
						(== global116 0)
						(proc501_2 global109)
					)
					(= global104 3)
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
								(proc255_0 46 0)
							)
							((Said '/cavity,pit,dune,bank,partition') (proc255_0 46 1))
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
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

(instance Actions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(else )
		)
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
				)
				(cond 
					((< (gEgo x?) 210) (gEgo setMotion: MoveTo 204 170 self))
					((< (gEgo x?) 269) (gEgo setMotion: MoveTo 252 170 self))
					(else (gEgo setMotion: MoveTo 296 168 self))
				)
			)
			(1
				(proc0_3)
				(gEgo view: 82 setLoop: -1 setAvoider: 0 setStep: 2 1)
				(= global104 2)
				(global2 setScript: 0)
			)
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
