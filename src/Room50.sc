;;; Sierra Script 1.0 - (do not remove this comment)
(script# 50)
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
	Room50 0
)

(local
	local0
	gEgoY
	theGGEgoX_5
	theTheGGEgoX_5
	local4
	local5
)
(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room50 of Rm
	(properties
		picture 50
	)
	
	(method (init)
		(= east 51)
		(= west 49)
		(= south 53)
		(= north 47)
		(= global109 1)
		(= global591 1)
		(= global116 0)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(gEgo view: 0 init:)
		(lightning
			view: 69
			loop: 4
			cel: 0
			posn: 185 58
			setScript: flash
			init:
		)
		(switch gNorth
			(46
				(= global104 2)
				(gEgo
					posn: 186 67
					view: 68
					looper: 0
					setPri: 1
					setStep: 1 1
					ignoreControl: 8192
				)
			)
			(49
				(gEgo observeControl: 8192)
				(if (and (> (gEgo y?) 146) (< (gEgo y?) 155))
					(gEgo posn: 1 144)
				else
					(gEgo posn: 1 (gEgo y?))
				)
			)
			(51
				(switch global104
					(1
						(gEgo
							view: 82
							posn: 317 (gEgo y?)
							ignoreControl: 8192
							setStep: 1 1
							setPri: 1
						)
					)
					(2
						(gEgo
							view: 68
							posn: 317 (gEgo y?)
							setStep: 1 1
							setPri: 1
						)
					)
					(0
						(gEgo
							view: 0
							posn: 317 (gEgo y?)
							setStep: 3 2
							observeControl: 8192
							setPri: -1
						)
					)
				)
			)
			(53
				(proc0_1)
				(gEgo view: 0 posn: (gEgo x?) 188 observeControl: 8192)
			)
			(else 
				(gEgo posn: 180 98 observeControl: 8192)
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
			(= gGEgoX_4 176)
			(= gGEgoY_3 85)
			(switch gNorth
				(east (gNewAct posn: 359 117))
				(west (gNewAct posn: -40 117))
				(south (gNewAct posn: 160 249))
				(north (gNewAct posn: 176 85))
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1)
		else
			((ScriptID 501 0) notify: 4)
		)
		(gEgo observeControl: 1024)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(= local0 (gEgo onControl: 0))
		(if (IsObject (gEgo mover?))
			(= theTheGGEgoX_5 ((gEgo mover?) x?))
			(= local4 ((gEgo mover?) y?))
			(= local5 1)
		else
			(= local5 0)
		)
		(cond 
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (proc501_2 1)
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
				(= global116 2)
				(= global104 1)
				(= gGEgoX_4 (gEgo x?))
				(= gGEgoY_3 (gEgo y?))
				(if local5
					(if gGEgoY_4
						(= gEgoY 400)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY (+ (- (gEgo y?) local4) (gEgo y?)))
						(= theGGEgoX_5 theTheGGEgoX_5)
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
					setPri: 1
					ignoreControl: 8192
				)
			)
			((and (& local0 $0010) (== global104 2)) (global2 newRoom: 46))
			(
				(and
					(& local0 $0002)
					(== global104 1)
					(not global155)
					(not global116)
				)
				(= global116 2)
				(= global104 0)
				(if local5
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY (+ (- (gEgo y?) local4) (gEgo y?)))
						(= theGGEgoX_5 theTheGGEgoX_5)
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
				(if local5
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY (+ (- (gEgo y?) local4) (gEgo y?)))
						(= theGGEgoX_5 theTheGGEgoX_5)
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
				(= global116 4)
				(= global104 1)
				(if local5
					(if gGEgoY_4
						(= gEgoY -400)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY -400)
						(= theGGEgoX_5 theTheGGEgoX_5)
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
					setStep: 2 1
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: 1
					ignoreControl: 8192
				)
			)
			(
				(and
					(!= global104 2)
					(== global116 0)
					(or
						(proc501_2 global109)
						(and (> (gEgo x?) 217) (< (gEgo y?) 80))
						(and
							(> (gEgo x?) 87)
							(< (gEgo x?) 108)
							(< (gEgo y?) 60)
						)
						(< (gEgo y?) 54)
					)
				)
				(= global104 1)
				(= gEgoY 180)
				(= theGGEgoX_5 (gEgo x?))
				(gEgo setPri: 1 posn: (gEgo x?) (+ (gEgo y?) 8))
				(proc0_10)
				(gEgo
					view: 82
					looper: (ScriptID 501 1)
					xStep: 2
					yStep: 1
					setMotion: MoveTo theGGEgoX_5 gEgoY
					ignoreControl: 8192
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 5])
		(if (pEvent claimed?) (return 1))
		(return
			(switch (pEvent type?)
				(evSAID
					(cond 
						((Said 'look>')
							(cond 
								(
									(or
										(Said '/area')
										(Said '/around')
										(Said '[<around][/!*]')
									)
									(proc255_0 50 0)
								)
								((Said '/rock') (proc255_0 50 1))
								((Said '/dune') (proc255_0 50 2))
								((Said '/cavity') (proc255_0 50 3))
							)
						)
						((Said '/cavity') (proc255_0 50 4))
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
				(< (gEgo distanceTo: gNewAct) 85)
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
