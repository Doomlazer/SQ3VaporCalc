;;; Sierra Script 1.0 - (do not remove this comment)
(script# 501)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Chase)
(use Avoid)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	regDune 0
	DUNELOOPER 1
	proc501_2 2
	proc501_3 3
)

(local
	local0
	local1
	local2
	local3
	newSound
	local5
	local6
	[local7 12]
)
(procedure (proc501_2 param1 &tmp temp0)
	(return
		(if
		(& (= temp0 (OnControl 2 (gEgo x?) (gEgo y?))) param1)
			(return 1)
		else
			(return 0)
		)
	)
)

(procedure (proc501_3 param1 &tmp temp0)
	(= temp0 0)
	(while param1
		(= param1 (>> param1 $0001))
		(++ temp0)
	)
	(return (- temp0 1))
)

(class AView of View
	(properties
		y 0
		x 0
		z 0
		heading 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0101
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
	)
	
	(method (delete)
		(= signal (& signal $ffdf))
		(super delete:)
	)
)

(instance footPrint of AView
	(properties)
)

(class dMoveTo of Motion
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
	)
	
	(method (init theClient theX theY theCaller &tmp [temp0 2])
		(= client theClient)
		(= x theX)
		(if (!= (gEgo looper?) 0)
			(= y (+ (gEgo y?) (- (gEgo y?) theY)))
		else
			(= y theY)
		)
		(if (== argc 4) (= caller theCaller))
		(= b-moveCnt 0)
		(theClient
			heading: (GetAngle (theClient x?) (theClient y?) x y)
		)
		(if (== global104 1)
			(cond 
				(
				(or (< (gEgo heading?) 45) (> (gEgo heading?) 315)) (gEgo loop: 2))
				(
				(and (>= (gEgo heading?) 45) (< (gEgo heading?) 135)) (gEgo loop: 0))
				(
				(and (>= (gEgo heading?) 135) (< (gEgo heading?) 225)) (gEgo loop: 3))
				(else (gEgo loop: 1))
			)
		else
			(DirLoop theClient (theClient heading?))
		)
		(InitBresen self)
	)
)

(instance regDune of Rgn
	(properties)
	
	(method (init)
		(Load rsVIEW 777)
		(Load rsVIEW 82)
		(Load rsVIEW 0)
		(Load rsVIEW 68)
		(Load rsVIEW 106)
		(Load rsVIEW 108)
		(User mapKeyToDir: 0)
		(super init:)
	)
	
	(method (dispose)
		(User mapKeyToDir: 1)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp pEventType gEgoX gEgoY temp3 temp4 theGPEventMessage)
		(if (pEvent claimed?) (return 1))
		(return
			(if (== (User controls?) 1)
				(= pEventType (pEvent type?))
				(MapKeyToDir pEvent)
				(switch (pEvent type?)
					(evMOUSEBUTTON
						(if (and (global2 controls?) (IsObject gEgo))
							(= gGEgoY_4 (pEvent y?))
							(= gGEgoX_5 (pEvent x?))
							(= gGEgoY_5 (gEgo y?))
							(gEgo setMotion: dMoveTo (pEvent x?) (pEvent y?))
							(User prevDir: 0)
							(pEvent claimed: 1)
						)
					)
					(evJOYSTICK
						(if (and (global2 controls?) (IsObject gEgo))
							(= theGPEventMessage (pEvent message?))
							(= gGEgoX_5 0)
							(= gGEgoY_4 0)
							(if
								(and
									(== pEventType evKEYBOARD)
									(== gPEventMessage theGPEventMessage)
									(IsObject (gEgo mover?))
								)
								(= theGPEventMessage 0)
							)
							(= gPEventMessage theGPEventMessage)
							(if (== theGPEventMessage 0)
								(gEgo setMotion: 0)
								(return (pEvent claimed: 1))
							)
							(if (gEgo mover?)
								(if
									(==
										theGPEventMessage
										(cond 
											(
											(or (== global104 0) (== global104 4) (== global104 2))
												(cond 
													((== (gEgo heading?) 0) 1)
													((< (gEgo heading?) 90) 2)
													((== (gEgo heading?) 90) 3)
													((< (gEgo heading?) 180) 4)
													((== (gEgo heading?) 180) 5)
													((< (gEgo heading?) 270) 6)
													((== (gEgo heading?) 270) 7)
													(else 8)
												)
											)
											((== (gEgo heading?) 180) 1)
											((< (gEgo heading?) 90) 4)
											((== (gEgo heading?) 90) 3)
											((< (gEgo heading?) 180) 2)
											((== (gEgo heading?) 0) 5)
											((< (gEgo heading?) 270) 8)
											((== (gEgo heading?) 270) 7)
											(else 6)
										)
									)
									(return (pEvent claimed: 1))
								)
							)
							(= gEgoX (gEgo x?))
							(= gEgoY (gEgo y?))
							(= temp3 (* (gEgo xStep?) 400))
							(= temp4 (* (gEgo yStep?) 400))
							(if
								(and
									(!= global104 0)
									(!= global104 4)
									(!= global104 2)
								)
								(= temp4 (* temp4 -1))
							)
							(switch theGPEventMessage
								(1 (= gEgoY (- gEgoY temp4)))
								(2
									(= gEgoX (+ gEgoX temp3))
									(= gEgoY (- gEgoY temp4))
								)
								(3 (= gEgoX (+ gEgoX temp3)))
								(4
									(= gEgoX (+ gEgoX temp3))
									(= gEgoY (+ gEgoY temp4))
								)
								(5 (= gEgoY (+ gEgoY temp4)))
								(6
									(= gEgoX (- gEgoX temp3))
									(= gEgoY (+ gEgoY temp4))
								)
								(7 (= gEgoX (- gEgoX temp3)))
								(8
									(= gEgoX (- gEgoX temp3))
									(= gEgoY (- gEgoY temp4))
								)
							)
							(gEgo setMotion: MoveTo gEgoX gEgoY)
							(pEvent claimed: 1)
						)
					)
					(evSAID
						(cond 
							((Said 'look>')
								(cond 
									((Said '/desert') (proc255_0 501 0))
									((Said '/dirt,dirt') (proc255_0 501 1))
									((Said '/dune') (proc255_0 501 2))
									((or (Said '/dirt') (Said '<down')) (proc255_0 501 3))
									((Said '/lightning') (proc255_0 501 4))
									((or (Said '/cloud,air') (Said '<up')) (proc255_0 501 5))
									((Said '/down') (proc255_0 501 6))
									((Said '/bug')
										(if (gCast contains: local6)
											(proc255_0 501 7)
										else
											(proc255_0 501 8)
										)
									)
									((Said '/butte,toe') (proc255_0 501 9))
									((Said '/footprint')
										(if (gCast contains: gNewAct)
											(proc255_0 501 10)
										else
											(proc255_0 501 11)
										)
									)
									((Said '/rock') (proc255_0 501 12))
									((Said '/cloud') (proc255_0 501 13))
									((Said '/butte') (proc255_0 501 14))
								)
							)
							((Said 'get>')
								(cond 
									((Said '/dirt') (proc255_0 501 15))
									((Said '/rock') (proc255_0 501 16))
									((Said '/bug')
										(if (gCast contains: local6)
											(proc255_0 501 17)
										else
											(proc255_0 501 8)
										)
									)
								)
							)
							((Said 'conceal') (proc255_0 501 18))
							((Said 'dig') (proc255_0 501 19))
							((or (Said 'attack/bug') (Said 'stair/bug')) (if (gCast contains: local6) (proc255_0 501 20)))
							((Said 'climb,sit,crawl,lie') (proc255_0 501 21))
							((Said 'converse/android')
								(if (gCast contains: gNewAct)
									(proc255_0 501 22)
								else
									(proc255_0 501 23)
								)
							)
						)
					)
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
	
	(method (notify param1)
		(switch param1
			(1
				(gNewAct view: 777 setCycle: Walk setScript: tActions)
				(= local0 0)
			)
			(2 (gNewAct dispose:))
			(3
				(gNewAct
					view: 777
					setMotion: 0
					setScript: 0
					ignoreActors:
				)
			)
			(4
				(if (== (Random 1 4) 3)
					((= local6 (ScriptID 511 0)) init:)
				)
			)
		)
	)
)

(instance DUNELOOPER of Script
	(properties)
	
	(method (doit)
		(if (or (== global104 1) (== global104 3))
			(gEgo
				loop:
					(cond 
						(
						(or (< (gEgo heading?) 45) (> (gEgo heading?) 315)) 2)
						(
						(and (>= (gEgo heading?) 45) (< (gEgo heading?) 135)) 0)
						(
						(and (>= (gEgo heading?) 135) (< (gEgo heading?) 225)) 3)
						(else 1)
					)
			)
		else
			(DirLoop gEgo (gEgo heading?))
		)
	)
)

(instance tActions of Script
	(properties)
	
	(method (doit)
		(asm
			lsg      gGNorth
			lag      gNewRoomNumber
			ne?     
			bnt      code_0a8a
			ret     
code_0a8a:
			lsg      global104
			ldi      0
			ne?     
			bnt      code_0ab6
			lsl      local0
			ldi      1
			eq?     
			bnt      code_0ab6
			ldi      7
			aTop     state
			sal      local0
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			lsg      gGEgoX_4
			lsg      gGEgoY_3
			pushSelf
			pushi    217
			pushi    1
			pushi    2
			lag      gNewAct
			send     18
code_0ab6:
			lsl      local0
			ldi      7
			eq?     
			bnt      code_0ae7
			pushi    #onControl
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      2
			and     
			bnt      code_0ae7
			pushi    #view
			pushi    1
			pushi    777
			pushi    213
			pushi    1
			pushi    0
			lag      gNewAct
			send     12
			pushi    #changeState
			pushi    1
			pushi    8
			self     6
			ldi      8
			sal      local0
code_0ae7:
			lsl      local0
			ldi      8
			eq?     
			bt       code_0af7
			lsl      local0
			ldi      7
			eq?     
			bnt      code_0b2b
code_0af7:
			lsg      global104
			ldi      0
			eq?     
			bnt      code_0b2b
			pushi    #view
			pushi    1
			pushi    106
			pushi    216
			pushi    1
			pushi    2
			pushi    214
			pushi    1
			class    Avoid
			push    
			pushi    213
			pushi    4
			class    Chase
			push    
			lsg      gEgo
			pushi    10
			pushSelf
			lag      gNewAct
			send     30
			ldi      0
			aTop     seconds
			ldi      1
			aTop     state
			sal      local0
code_0b2b:
			lsl      local0
			ldi      10
			ne?     
			bnt      code_0bbb
			pushi    5
			pushi    2
			pushi    #x
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      9
			sub     
			push    
			pushi    #y
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      3
			sub     
			push    
			pushi    #x
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      9
			add     
			push    
			pushi    #y
			pushi    0
			lag      gNewAct
			send     4
			push    
			callk    OnControl,  10
			push    
			lag      global591
			and     
			bnt      code_0bbb
			lsl      local0
			ldi      1
			eq?     
			bnt      code_0ba8
			pushi    199
			pushi    #-info-
			lsl      local1
			lsl      local2
			ldi      3
			add     
			push    
			lag      gNewAct
			send     8
			ldi      0
			aTop     seconds
			ldi      1
			aTop     state
			pushi    #setAvoider
			pushi    1
			class    Avoid
			push    
			pushi    213
			pushi    4
			class    Chase
			push    
			lsg      gEgo
			pushi    10
			pushSelf
			lag      gNewAct
			send     18
			jmp      code_0bbb
code_0ba8:
			pushi    #setMotion
			pushi    1
			pushi    0
			pushi    205
			pushi    0
			pushi    5
			pushi    1
			pushi    777
			lag      gNewAct
			send     16
code_0bbb:
			pushi    3
			pushi    1
			pushi    #x
			pushi    0
			lag      gNewAct
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gNewAct
			send     4
			push    
			callk    OnControl,  6
			push    
			ldi      0
			ne?     
			bnt      code_0bea
			pushi    #x
			pushi    0
			lag      gNewAct
			send     4
			sal      local1
			pushi    #y
			pushi    0
			lag      gNewAct
			send     4
			sal      local2
code_0bea:
			lsl      local0
			ldi      1
			eq?     
			bt       code_0bfa
			lsl      local0
			ldi      7
			eq?     
			bnt      code_0ca5
code_0bfa:
			pushi    #cel
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      0
			eq?     
			bt       code_0c32
			pushi    #loop
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      2
			lt?     
			bnt      code_0c24
			pushi    #cel
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      4
			eq?     
			jmp      code_0c2f
code_0c24:
			pushi    #cel
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      3
			eq?     
code_0c2f:
			bnt      code_0ca5
code_0c32:
			pushi    3
			pushi    2
			pushi    #x
			pushi    0
			lag      gNewAct
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gNewAct
			send     4
			push    
			callk    OnControl,  6
			sal      local3
			pushi    1
			push    
			call     proc501_3,  2
			sal      local3
			push    
			ldi      65535
			ne?     
			bnt      code_0ca5
			pushi    #view
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      777
			ne?     
			bnt      code_0ca5
			pushi    #view
			pushi    1
			pushi    106
			pushi    6
			pushi    1
			pushi    #loop
			pushi    0
			lag      gNewAct
			send     4
			push    
			pushi    7
			pushi    1
			pushi    #cel
			pushi    0
			lag      gNewAct
			send     4
			push    
			pushi    205
			pushi    1
			pushi    1
			pushi    199
			pushi    2
			pushi    #x
			pushi    0
			lag      gNewAct
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gNewAct
			send     4
			push    
			pushi    207
			pushi    0
			lofsa    footPrint
			send     36
code_0ca5:
			lsg      gGNorth
			lag      gNewRoomNumber
			ne?     
			bnt      code_0cae
			ret     
code_0cae:
			pushi    #doit
			pushi    0
			super    Script,  4
			ret     
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds gSeconds))
			(1
				(if (== global104 0)
					(gNewAct
						view: 106
						setMotion: Chase gEgo 10 self
						setAvoider: Avoid
						ignoreActors:
					)
					(= local0 1)
				else
					(= local0 (= state 7))
					(gNewAct
						view: 106
						setMotion: MoveTo gGEgoX_4 gGEgoY_3 self
						ignoreControl: 2
					)
				)
			)
			(2
				(if (!= gGNorth gNewRoomNumber) (return))
				(= local0 10)
				(= global116 1)
				(proc0_2)
				(gNewAct
					ignoreActors:
					illegalBits: 0
					posn: (gEgo x?) (gEgo y?)
				)
				(gEgo
					view: 106
					setLoop: 4
					cel: 255
					ignoreHorizon:
					illegalBits: 0
					setCycle: End
					setPri: (gEgo priority?)
					setStep: 4 4
					setMotion: MoveTo (+ (gEgo x?) 11) (- (gEgo y?) 15) self
				)
				(proc0_10)
			)
			(3
				(gEgo setLoop: 5 setCycle: Fwd)
				(gNewAct
					view: 106
					setLoop: 6
					illegalBits: 0
					setPri: (gEgo priority?)
					setCycle: Fwd
					show:
				)
				(= seconds 2)
			)
			(4
				(gNewAct
					view: 106
					setLoop: 7
					setPri: (gEgo priority?)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(5
				(gEgo hide:)
				((= newSound (Sound new:))
					number: 97
					loop: -1
					priority: 99
					play:
				)
				(gNewAct setLoop: 8 setCycle: Fwd)
				(= seconds 6)
			)
			(6
				(newSound stop:)
				(gNewAct setLoop: 8 setCel: 0)
				(proc0_17 901 0 14 16)
			)
			(8 (= seconds 12) (= local0 8))
			(9
				(if (and (!= global104 1) (!= global104 0))
					(= seconds (= state 8))
				else
					(self changeState: 2)
				)
			)
		)
	)
)
