;;; Sierra Script 1.0 - (do not remove this comment)
(script# 52)
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
	Room52 0
)

(local
	local0
	gEgoY
	theGGEgoX_5
	local3
	local4
	newAct
	theTheGGEgoX_5
	local7
	local8
)
(instance puss of Prop
	(properties)
)

(instance mouth of Prop
	(properties)
)

(instance tongue of Prop
	(properties)
)

(instance slurp of Sound
	(properties)
)

(instance Room52 of Rm
	(properties
		picture 52
	)
	
	(method (init)
		(= north 48)
		(= west 51)
		(= east 49)
		(= south 53)
		(Load rsVIEW 78)
		(Load rsVIEW 122)
		(Load rsVIEW 777)
		(Load rsSOUND 82)
		(= global109 1)
		(= global591 1)
		(super init:)
		(= global116 0)
		(if (== global117 52)
			((= gNewView (View new:))
				view: 78
				setLoop: 8
				setCel: 255
				setPri: 5
				posn: 208 125
				init:
				stopUpd:
			)
		)
		(if (proc0_13 16 52)
			((= gNewView_2 (View new:))
				view: 120
				loop: 5
				cel: 0
				ignoreActors:
				posn: 209 128
				setPri: 6
				init:
				stopUpd:
			)
		)
		(proc0_1)
		(puss
			view: 78
			loop: 0
			cel: 1
			posn: 204 50
			setPri: 7
			setCycle: Fwd
			init:
		)
		(mouth
			view: 777
			ignoreActors:
			loop: 0
			cel: 0
			posn: 207 48
			setPri: 9
			init:
		)
		(tongue
			view: 777
			loop: 0
			cel: 0
			ignoreActors:
			posn: 207 59
			setPri: 10
			init:
		)
		(gEgo init:)
		(switch gNorth
			(48
				(= global104 2)
				(gEgo posn: 119 70 view: 68 setPri: 1 ignoreControl: 8192)
			)
			(53
				(proc0_1)
				(gEgo
					view: 0
					posn: (gEgo x?) 188
					observeControl: 8192 4096
				)
			)
			(51
				(switch global104
					(0
						(gEgo
							posn: 1 (gEgo y?)
							setStep: 3 2
							observeControl: 8192 4096
							setPri: -1
						)
					)
					(1
						(gEgo
							posn: 1 113
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							observeControl: 4096
							looper: (ScriptID 501 1)
							setPri: 1
						)
					)
					(2
						(gEgo
							view: 68
							posn: 1 85
							looper: 0
							ignoreControl: 8192 4096
							setStep: 1 1
							setPri: 1
						)
					)
				)
			)
			(49
				(gEgo
					view: 0
					observeControl: 8192 4096
					setStep: 3 2
					setPri: -1
				)
				(if (< (gEgo y?) 126)
					(gEgo posn: 314 102)
				else
					(gEgo posn: 318 (gEgo y?))
				)
			)
			(else 
				(gEgo view: 0 posn: 160 160)
			)
		)
		(self setRegions: 501)
		(switch global110
			(1
				(if (== (Random 1 2) 2)
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
				observeControl: 2 8192 4096
				posn: 1000 1000
				init:
			)
			(= gGEgoX_4 166)
			(= gGEgoY_3 105)
			(switch gNorth
				(east (gNewAct posn: 359 152))
				(west (gNewAct posn: -40 158))
				(south (gNewAct posn: 218 249))
				(north (gNewAct posn: 166 105))
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1)
		)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
			(and
				(== global104 0)
				(gEgo inRect: 200 117 237 134)
				(== (global2 script?) 0)
			)
			(self setScript: egoDeath)
		)
		(if
			(and
				(gCast contains: gNewAct)
				(gNewAct inRect: 200 117 237 134)
				(== (global2 script?) 0)
			)
			(self setScript: termDeath)
		)
		(if (IsObject (gEgo mover?))
			(= theTheGGEgoX_5 ((gEgo mover?) x?))
			(= local7 ((gEgo mover?) y?))
			(= local8 1)
		else
			(= local8 0)
		)
		(cond 
			((& (= local0 (gEgo onControl: 0)) $0008) (global2 newRoom: 48))
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (proc501_2 1)
					(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
				)
			)
			((and (== global116 4) (not (& local0 $0004))) (= global116 0) (gEgo ignoreControl: 4))
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
				(if local8
					(if gGEgoY_4
						(= gEgoY 400)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY (+ (- (gEgo y?) local7) (gEgo y?)))
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
				(= global104 0)
				(= global116 2)
				(if local8
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY (+ (- (gEgo y?) local7) (gEgo y?)))
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
				(if local8
					(if gGEgoY_4
						(= gEgoY gGEgoY_4)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY (+ (- (gEgo y?) local7) (gEgo y?)))
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
					setPri: 4
					ignoreControl: 4096
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
				(if local8
					(if gGEgoY_4
						(= gEgoY -400)
						(= theGGEgoX_5 gGEgoX_5)
					else
						(= gEgoY (+ (- (gEgo y?) local7) (gEgo y?)))
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
					xStep: 2
					yStep: 1
					setMotion: MoveTo theGGEgoX_5 gEgoY
					setPri: 4
					observeControl: 4096
					ignoreControl: 8192
				)
			)
			(
				(and
					(or (== global104 0) (== global104 1))
					(== global116 0)
					(or (proc501_2 global109) (< (gEgo y?) 92))
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
						((Said 'look,explore/android,debris,heap')
							(cond 
								((gCast contains: gNewView)
									(proc255_0
										(Format
											@global402
											52
											0
											(if
												(and
													(proc0_13 16 52)
													(< (gEgo distanceTo: gNewView) 60)
													(== global104 0)
												)
												{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
											else
												{}
											)
										)
									)
								)
								((gCast contains: gNewAct) (proc255_0 52 1))
								(else (proc255_0 52 2))
							)
						)
						((Said 'look>')
							(cond 
								(
									(or
										(Said '/area')
										(Said '/around')
										(Said '[<around][/!*]')
									)
									(proc255_0 52 3)
								)
								((Said '/chute') (proc255_0 52 4))
								((Said '/rock') (proc255_0 52 5))
								((Said '/tongue') (proc255_0 52 6))
							)
						)
						((Said 'converse/chute') (proc255_0 52 7))
						((Said 'beat,attack/chute') (proc255_0 52 8))
						((Said 'get/chute') (proc255_0 52 9))
						((Said 'climb/') (proc255_0 52 10))
						(
							(or
								(Said 'get/belt/orat,stick')
								(Said 'use/stick,orat')
								(Said 'get<use<(stick,orat)/belt')
							)
							(cond 
								((gEgo has: 16) (proc255_0 52 11))
								((not (proc0_13 16 52)) (proc255_0 52 2))
								((not (gEgo has: 4)) (proc255_0 52 12))
								((!= global110 3) (proc255_0 52 13))
								(
									(or
										(not (gEgo inRect: 160 107 198 147))
										(!= global104 0)
									)
									(proc255_0 52 14)
								)
								(else (global2 setScript: (ScriptID 520 0)))
							)
						)
						((or (Said 'get/belt/pole') (Said 'use/pole'))
							(cond 
								((gEgo has: 16) (proc255_0 52 11))
								((not (proc0_13 16 52)) (proc255_0 52 2))
								((not (gEgo has: 9)) (proc255_0 52 12))
								((!= global110 3) (proc255_0 52 13))
								(
									(and
										(not (gEgo inRect: 200 117 237 134))
										(!= global104 0)
									)
									(proc255_0 52 14)
								)
								(else (global2 setScript: (ScriptID 521 0)))
							)
						)
						((Said 'get/belt')
							(if (proc0_13 16 52)
								(proc255_0 52 15)
							else
								(proc255_0 52 2)
							)
						)
						((Said '/ladder') (proc0_9))
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not global155)
			(proc0_1)
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

(instance egoDeath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 0)
				(proc0_2)
				(if (gCast contains: gNewAct)
					((ScriptID 501) notify: 2)
				)
				(= global116 9999)
				(slurp number: 82 priority: 3 loop: 1 play:)
				(mouth
					view: 78
					setLoop: 1
					cel: 255
					x: (gEgo x?)
					setCycle: End self
				)
			)
			(1
				(tongue view: 78 setLoop: 2 x: (gEgo x?) show:)
				(gEgo
					view: 78
					setLoop: 3
					setCycle: Fwd
					setPri: 8
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo (gEgo x?) 109 self
				)
			)
			(2
				(tongue setCel: 1)
				(gEgo setMotion: MoveTo (gEgo x?) 92 self)
			)
			(3
				(tongue view: 777 loop: 0)
				(gEgo setMotion: MoveTo (gEgo x?) 78 self)
				((= newAct (Act new:)) view: 777 loop: 0 init:)
			)
			(4
				(gEgo view: 777 loop: 0)
				(mouth setLoop: 4 setCycle: Fwd)
				(newAct
					view: 78
					setLoop: 5
					ignoreActors:
					illegalBits: 0
					posn: (gEgo x?) 67
					setPri: 8
					setStep: 1 4
					setMotion: MoveTo (gEgo x?) 129 self
				)
				(= local3 (+ local3 1))
			)
			(5
				(if (<= local3 6)
					(= state 3)
					(= cycles 2)
				else
					(newAct dispose:)
					(= cycles 1)
				)
			)
			(6 (proc0_17 901 1 0 999))
		)
	)
)

(instance termDeath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gNewAct ignoreActors: setMotion: 0)
				(mouth
					view: 78
					setLoop: 1
					cel: 255
					x: (gNewAct x?)
					setCycle: End self
				)
			)
			(1
				(tongue view: 78 setLoop: 2 cel: 0 x: (gNewAct x?))
				(= gNewView (Act new:))
				(gNewView
					view: 78
					posn: (gNewAct x?) (gNewAct y?)
					setLoop: 6
					setCycle: Fwd
					setPri: 8
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo (gNewAct x?) 109 self
					init:
				)
				((ScriptID 501) notify: 2)
			)
			(2
				(tongue setCel: 1)
				(gNewView setMotion: MoveTo (gNewView x?) 92 self)
			)
			(3
				(tongue view: 777 loop: 0)
				(gNewView setMotion: MoveTo (gNewView x?) 78 self)
			)
			(4
				(gNewView view: 777 loop: 0)
				(mouth setLoop: 7 setCel: 0)
				(= seconds 3)
			)
			(5
				(mouth setCel: 1)
				(= cycles 2)
			)
			(6
				(cond 
					((>= (gNewView x?) 230) (= theGGEgoX_5 230))
					((<= (gNewView x?) 208) (= theGGEgoX_5 208))
					(else (= theGGEgoX_5 (gNewView x?)))
				)
				(gNewView
					view: 78
					posn: (gNewView x?) 72
					setLoop: 8
					setCel: 0
					setStep: 1 6
					setMotion: MoveTo theGGEgoX_5 125 self
				)
			)
			(7
				(mouth view: 777 loop: 0)
				(gGame changeScore: 45)
				(gNewView setCel: -1 setPri: 5 setCycle: End self)
			)
			(8
				(proc0_3)
				(= gNewView_2 (View new:))
				(gNewView_2
					view: 78
					loop: 9
					cel: 1
					setPri: 6
					posn: (gNewView x?) (+ (gNewView y?) 3)
					init:
				)
				(= global110 3)
				(= global117 52)
				(proc0_14 16 52)
				(global2 setScript: 0)
			)
		)
	)
)
