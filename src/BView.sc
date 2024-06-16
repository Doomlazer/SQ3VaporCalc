;;; Sierra Script 1.0 - (do not remove this comment)
(script# 43)
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
	rm43 0
)

(local
	local0
	newProp
	newProp_2
	newProp_3
	local4
	newAct
	newSound
)
(class BView of View
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

(instance footPrint of BView
	(properties)
)

(instance rm43 of Rm
	(properties
		picture 43
		style $0007
		east 44
		south 47
		west 42
	)
	
	(method (init)
		(User canInput: 1 canControl: 0)
		(proc0_1)
		(if (not global152) (Load rsVIEW 66) (Load rsVIEW 67))
		(Load rsVIEW 70)
		(Load rsVIEW 121)
		(Load rsSOUND 13)
		(super init:)
		(w init:)
		(orld init: addToPic:)
		(o init: addToPic:)
		(wonder init: addToPic:)
		(if (or (== global110 1) (== global110 2))
			(gEgo observeControl: 16384)
			(door
				view: 121
				loop: 0
				cel: 0
				posn: 157 118
				init:
				stopUpd:
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
			(switch gNorth
				(east (gNewAct posn: 359 140))
				(west (gNewAct posn: -40 140))
				(south (gNewAct posn: 160 249))
			)
			(= global110 1)
			(self setScript: tActions)
		)
		(if (not global152)
			(car init:)
			(shadow init:)
			(proc0_2)
			(self setScript: kid1Script)
		else
			(if (!= (gLongSong number?) 22)
				(gLongSong number: 22 priority: 1 loop: -1 play:)
			)
			(gEgo view: 0 setStep: 3 2 illegalBits: -32768 init:)
			(switch gNorth
				(42 (gEgo posn: 2 (gEgo y?)))
				(44
					(if (< (gEgo y?) 110)
						(gEgo posn: 317 110)
					else
						(gEgo posn: 317 (gEgo y?))
					)
				)
				(47 (gEgo posn: (gEgo x?) 187))
				(470
					(gEgo
						view: (if global130 138 else 0)
						posn: 158 125
						loop: 2
						cel: 0
					)
					(if global130 (Load rsVIEW 755))
					(cond 
						((== global110 0)
							(proc0_2)
							(= global110 1)
							(self setScript: terminatorGrabs)
							(Load rsPIC 430)
							(Load rsVIEW 107)
							(Load rsVIEW 121)
						)
						(global130 (self setScript: hatTrick))
					)
				)
				(else  (gEgo posn: 160 187))
			)
			(if (!= (global2 script?) terminatorGrabs) (proc0_3))
		)
		(= local0 1)
	)
	
	(method (doit &tmp [temp0 30])
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
			(or
				(== (gEgo onControl: 0) 4)
				(== (gEgo onControl: 0) 5)
			)
			(self newRoom: 470)
		)
		(if (== (-- local0) 0)
			(if (== (w cel?) 0) (w cel: 1) else (w cel: 0))
			(= local0 (Random 1 4))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look/leg') (proc255_0 43 0))
					((Said 'look/feet,s') (proc255_0 43 1))
					(
						(or
							(Said 'devil,s')
							(Said '/devil,s')
							(Said '//devil,s')
						)
						(proc255_0 43 2)
					)
					((Said 'look/door,entrance,door')
						(if (gCast contains: door)
							(proc255_0 43 3)
						else
							(proc255_0 43 4)
						)
					)
					((Said 'knock/door')
						(if (gCast contains: door)
							(if (< (gEgo distanceTo: door) 10)
								(proc255_0 43 5)
							else
								(proc0_5)
							)
						else
							(proc255_0 43 6)
						)
					)
					((Said 'open/door')
						(if (gCast contains: door)
							(if (< (gEgo distanceTo: door) 10)
								(proc255_0 43 7)
							else
								(proc0_5)
							)
						else
							(proc255_0 43 6)
						)
					)
					((or (Said 'get/cap') (Said 'get<up/cap'))
						(if (gEgo has: 6)
							(proc255_0 43 8)
						else
							(proc255_0 43 9)
						)
					)
					(
						(Said
							'look/box,table,glass,animal,animal,lawn,slime,display'
						)
						(if (gEgo inRect: 189 110 246 130)
							(proc255_0 43 10)
						else
							(proc255_0 43 11)
						)
					)
					((Said 'break/box,glass')
						(if (gEgo inRect: 189 110 246 130)
							(proc255_0 43 12)
						else
							(proc0_5)
						)
					)
					((Said 'open/box')
						(cond 
							((== (global2 script?) tActions) (proc255_0 43 13))
							((gEgo inRect: 189 110 246 130) (global2 setScript: AlienDeath))
							(else (proc255_0 43 14))
						)
					)
					((Said 'read,look/menace[<neon,flashing]')
						(if
							(and
								(gCast contains: door)
								(gEgo inRect: 102 90 246 143)
							)
							(proc255_0 43 15)
						else
							(proc255_0 43 16)
							(if (gCast contains: door) (proc255_0 43 17))
						)
					)
					(
						(or
							(Said 'look/area')
							(Said 'look/building,hill,animal')
							(Said 'look[<around][/!*]')
						)
						(proc255_0 43 18)
					)
				)
			)
			(evKEYBOARD
				(if
					(and
						(== (pEvent type?) evKEYBOARD)
						(== (pEvent message?) KEY_RETURN)
						(== (global2 script?) terminatorGrabs)
						(<= 5 (terminatorGrabs state?))
						(<= (terminatorGrabs state?) 8)
					)
					(proc0_12)
					(pEvent claimed: 1)
					(terminatorGrabs seconds: 0)
					(terminatorGrabs cue:)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (or (not script) (== script tActions))
			(gEgo illegalBits: -32768)
			(cond 
				((!= newRoomNumber 470)
					(gLongSong
						owner: -1
						number: 22
						priority: 0
						loop: -1
						play:
					)
				)
				((== (gLongSong number?) 22) (gLongSong fade:))
			)
			(if
				(and
					(gCast contains: gNewAct)
					(< (gEgo distanceTo: gNewAct) 120)
				)
				(= global110 2)
			)
			(DisposeScript 988)
			(if (not global155) (super newRoom: newRoomNumber))
		)
	)
)

(instance kid1Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 13 priority: 3 loop: -1 play:)
				(kid1 init: setMotion: MoveTo 188 137 self)
			)
			(1
				(car setScript: kid2Script)
				(kid1 setMotion: MoveTo 246 160 self)
			)
			(2 (kid1 dispose:))
		)
	)
)

(instance kid2Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(kid2 init: setMotion: MoveTo 188 137 self)
			)
			(1
				(global2 setScript: momScript)
				(kid2 setMotion: MoveTo 246 160 self)
			)
			(2 (kid2 dispose:))
		)
	)
)

(instance momScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(mom init: setMotion: MoveTo 197 142 self)
			)
			(1
				(mom setMotion: MoveTo 284 149 self)
			)
			(2
				(car setScript: popScript)
				(mom setMotion: MoveTo 284 160 self)
			)
			(3 (mom dispose:))
		)
	)
)

(instance popScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(pop init: setMotion: MoveTo 152 120 self)
			)
			(1
				(pop setMotion: MoveTo 196 146 self)
			)
			(2
				(pop loop: 4 cel: 0 setCycle: Walk)
				(= cycles 2)
			)
			(3
				(pballoon init:)
				(pop cycleSpeed: 1 setCycle: End self)
			)
			(4
				(pballoon dispose:)
				(pop
					loop: 3
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 284 160 self
				)
				(global2 setScript: festerScript)
			)
			(5 (pop dispose:))
		)
	)
)

(instance festerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(fester init: setMotion: MoveTo 185 137 self)
			)
			(1
				(fester loop: 1 setCycle: End self)
			)
			(2
				(fester loop: 4 setCycle: Fwd)
				(fballoon init:)
				(gEgo setScript: carScript)
				(= seconds 4)
			)
			(3
				(fballoon cel: 1)
				(= seconds 4)
			)
			(4
				(fballoon dispose:)
				(fester loop: 1 cel: 2 setCycle: Beg self)
			)
			(5
				(fester
					loop: 2
					setCycle: Walk
					setMotion: MoveTo 141 108 self
				)
			)
			(6
				(fester dispose:)
				(gEgo init: view: 0 setStep: 3 2)
				(switch gNorth
					(42
						(gEgo
							posn: -5 (gEgo y?)
							setMotion: MoveTo 5 (gEgo y?) self
						)
					)
					(44
						(if (< (gEgo y?) 110)
							(gEgo posn: 324 110)
						else
							(gEgo posn: 324 (gEgo y?))
						)
						(gEgo setMotion: MoveTo 314 (gEgo y?) self)
					)
					(47
						(gEgo
							posn: (gEgo x?) 222
							setMotion: MoveTo (gEgo x?) 186 self
						)
					)
					(else 
						(gEgo posn: 160 222 setMotion: MoveTo 166 186 self)
					)
				)
			)
			(7
				(proc0_3)
				(client setScript: 0)
				(= global152 1)
			)
		)
	)
)

(instance carScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(car setMotion: MoveTo 278 160 self)
				(shadow setMotion: MoveTo 287 191)
			)
			(1
				(car xStep: 10 setMotion: MoveTo 368 160 self)
				(shadow xStep: 10 setMotion: MoveTo 368 191)
			)
			(2
				(car dispose:)
				(shadow dispose:)
				(dust init: setCycle: End self)
			)
			(3
				(dust dispose:)
				(self dispose:)
			)
		)
	)
)

(instance AlienDeath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (< (gEgo y?) 126)
					(gEgo setMotion: MoveTo (gEgo x?) 126 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo setMotion: MoveTo 228 126 self)
			)
			(2
				(gEgo
					view: 84
					setLoop: 0
					setCel: 255
					posn: 228 126
					ignoreControl:
					setMotion: 0
					setCycle: End self
				)
			)
			(3 (= seconds 2))
			(4
				(gEgo setLoop: 1 setCel: 255 setCycle: End self)
			)
			(5
				(gEgo
					setLoop: 2
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 218 133 self
				)
			)
			(6
				(gEgo setMotion: MoveTo 177 133 self)
			)
			(7
				(gEgo setMotion: MoveTo 173 151 self)
			)
			(8
				(gEgo setMotion: MoveTo 197 135 self)
			)
			(9
				(gEgo setMotion: MoveTo 175 150 self)
			)
			(10
				(gEgo setLoop: 3 setCel: 255 setCycle: End self)
			)
			(11
				(gEgo setLoop: 4 setCel: 255 setCycle: End self)
			)
			(12
				(proc255_0 43 19)
				(= global197 1)
			)
		)
	)
)

(instance car of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 0
			setCel: 0
			setPri: 15
			posn: 278 175
			xStep: 1
			ignoreActors:
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look/car') (proc255_0 43 20))
			)
		)
	)
)

(instance shadow of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 0
			setCel: 1
			setPri: 14
			posn: 280 176
			xStep: 1
			ignoreActors:
		)
	)
)

(instance kid1 of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 2
			setCel: 0
			posn: 139 109
			xStep: 6
			yStep: 3
			setCycle: Fwd
			ignoreActors:
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look/boy') (proc255_0 43 21))
			)
		)
	)
)

(instance kid2 of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 2
			setCel: 0
			posn: 139 109
			xStep: 6
			yStep: 3
			setCycle: Fwd
			ignoreActors:
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look/boy') (proc255_0 43 21))
			)
		)
	)
)

(instance mom of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 5
			setCel: 0
			posn: 144 109
			setCycle: Fwd
			xStep: 5
			yStep: 3
			ignoreActors:
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look/mom') (proc255_0 43 22))
			)
		)
	)
)

(instance pop of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 3
			setCel: 0
			posn: 142 111
			setCycle: Fwd
			xStep: 5
			yStep: 3
			ignoreActors:
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look/dad,man,alien') (proc255_0 43 23))
			)
		)
	)
)

(instance fester of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 67
			setLoop: 0
			setCel: 0
			posn: 141 108
			xStep: 3
			yStep: 2
			setCycle: Fwd
			ignoreActors:
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (Said 'look/man,blatz') (proc255_0 43 24))
			)
		)
	)
)

(instance fballoon of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 67
			setLoop: 3
			setCel: 0
			setPri: 15
			posn: 217 103
			ignoreActors:
		)
	)
)

(instance pballoon of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 6
			setCel: 0
			setPri: 15
			posn: 168 123
			stopUpd:
			ignoreActors:
		)
	)
)

(instance dust of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 1
			setCel: 0
			setPri: 15
			posn: 287 166
			ignoreActors:
		)
	)
)

(instance w of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 70
			setLoop: 1
			setCel: 0
			setPri: 15
			posn: 95 34
			ignoreActors:
		)
	)
)

(instance orld of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 70
			setLoop: 0
			setCel: 0
			posn: 116 35
			setPri: 14
			stopUpd:
		)
	)
)

(instance o of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 70
			setLoop: 0
			setCel: 1
			posn: 155 36
			setPri: 14
			stopUpd:
		)
	)
)

(instance wonder of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 70
			setLoop: 0
			setCel: 2
			posn: 178 61
			setPri: 14
			stopUpd:
		)
	)
)

(instance door of View
	(properties)
)

(instance terminatorGrabs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(Load rsVIEW 106)
				(gEgo setMotion: MoveTo 181 157 self)
			)
			(1
				(proc0_2)
				(= gNewAct (Act new:))
				(gNewAct
					ignoreActors:
					illegalBits: 0
					posn: (gEgo x?) (gEgo y?)
				)
				(if global130
					(= global130 0)
					(proc0_14 6 -1)
					(= newAct (Act new:))
					(newAct
						view: 755
						posn: (gEgo x?) (- (gEgo y?) 10)
						setAvoider: Avoid
						setStep: 5 5
						setCycle: Fwd
						setMotion: MoveTo -10 170
						init:
					)
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
			(2
				(gEgo setLoop: 5 setCycle: Fwd)
				(gNewAct
					view: 106
					setLoop: 6
					illegalBits: 0
					setPri: (gEgo priority?)
					setCycle: Fwd
					init:
				)
				(= seconds 2)
			)
			(3
				(gNewAct
					view: 106
					setLoop: 7
					setPri: (gEgo priority?)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(4
				(gNewAct setCel: 1)
				(proc0_10)
				(global2 drawPic: 430)
				(gCast eachElementDo: #hide)
				(= newProp (Prop new:))
				(newProp
					view: 107
					setLoop: 0
					cel: 6
					posn: 61 189
					setPri: 14
					cycleSpeed: 0
					setScript: mouthActions
					init:
				)
				(= newProp_2 (Prop new:))
				(newProp_2
					view: 107
					setLoop: 2
					posn: 149 86
					setPri: 14
					setCycle: Fwd
					init:
				)
				(= newProp_3 (Prop new:))
				(newProp_3
					view: 107
					setLoop: 1
					cel: 0
					posn: 160 52
					setPri: 14
					setScript: eyeActions
					init:
				)
				(= seconds 3)
			)
			(5
				(newProp cycleSpeed: 1 setCycle: Fwd)
				(proc255_0 43 25 33 600 67 -1 10 70 300 91)
				(= seconds 15)
			)
			(6
				(proc0_12)
				(proc255_0 43 26 33 600 67 -1 10 70 300 91)
				(= seconds 15)
			)
			(7
				(proc0_12)
				(proc255_0 43 27 33 600 67 -1 10 70 300 91)
				(= seconds 10)
			)
			(8
				(proc0_12)
				(proc255_0 43 28 33 600 67 -1 10 70 300 91)
				(= seconds 15)
			)
			(9
				(proc0_12)
				(gCast eachElementDo: #show)
				(newProp dispose:)
				(newProp_2 dispose:)
				(newProp_3 dispose:)
				(door
					view: 121
					loop: 0
					cel: 0
					posn: 157 118
					init:
					stopUpd:
				)
				(orld init: addToPic:)
				(o init: addToPic:)
				(wonder init: addToPic:)
				(global2 drawPic: 43)
				(= cycles 1)
			)
			(10
				(gNewAct setLoop: 7 setCycle: Fwd)
				(= seconds 2)
			)
			(11 (= seconds 2))
			(12
				(gNewAct setLoop: 6)
				(= seconds 3)
			)
			(13
				(gNewAct hide:)
				(gEgo
					cycleSpeed: 2
					setCycle: Beg
					setMotion: MoveTo (- (gEgo x?) 11) (+ (gEgo y?) 15) self
				)
			)
			(14
				(gEgo
					view: 0
					illegalBits: -32768
					observeControl: 16384
					cycleSpeed: 0
					setCycle: Walk
					setLoop: -1
					setStep: 3 2
					setPri: -1
					loop: 2
				)
				(proc0_3)
				(= gSeconds 10)
				(global2 setScript: tActions)
			)
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
			bnt      code_1e9f
			ret     
code_1e9f:
			lsl      local4
			ldi      1
			eq?     
			bt       code_1eaf
			lsl      local4
			ldi      7
			eq?     
			bnt      code_1f24
code_1eaf:
			pushi    #cel
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      0
			eq?     
			bt       code_1ee7
			pushi    #loop
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      2
			lt?     
			bnt      code_1ed9
			pushi    #cel
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      4
			eq?     
			jmp      code_1ee4
code_1ed9:
			pushi    #cel
			pushi    0
			lag      gNewAct
			send     4
			push    
			ldi      3
			eq?     
code_1ee4:
			bnt      code_1f24
code_1ee7:
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
			pushi    205
			pushi    1
			pushi    1
			pushi    207
			pushi    0
			lofsa    footPrint
			send     36
code_1f24:
			pushi    #doit
			pushi    0
			super    Script,  4
			ret     
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 106)
				(= seconds gSeconds)
			)
			(1
				(gNewAct
					view: 106
					setLoop: -1
					setCycle: Walk
					illegalBits: -32768
					observeControl: 16384
					show:
					setMotion: Chase gEgo 10 self
					setAvoider: Avoid
				)
				(= local4 1)
			)
			(2
				(proc0_2)
				(= local4 10)
				(gNewAct posn: (gEgo x?) (gEgo y?))
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
				(= seconds 4)
			)
			(4
				(gNewAct
					view: 106
					setLoop: 7
					setPri: (gEgo priority?)
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(5
				(gEgo hide:)
				((= newSound (Sound new:))
					number: 97
					loop: -1
					priority: 3
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
		)
	)
)

(instance eyeActions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(newProp_3 cel: 1)
				(= cycles (Random 4 10))
			)
			(1
				(newProp_3 cel: 0)
				(= state -1)
				(= cycles (Random 10 60))
			)
		)
	)
)

(instance mouthActions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(newProp setCycle: Fwd)
				(= seconds (Random 4 12))
			)
			(1
				(newProp setCycle: 0 cel: 1)
				(= state -1)
				(= cycles (Random 7 15))
			)
		)
	)
)

(instance hatTrick of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 181 157 self)
			)
			(1
				(proc255_0 43 29)
				(gEgo view: 0)
				(= global130 0)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)
