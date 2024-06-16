;;; Sierra Script 1.0 - (do not remove this comment)
(script# 702)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Chase)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	scumSoft 0
)

(local
	scriptClient
	local1
	local2
	local3
	[local4 63] = [0 10 161 0 41 160 0 74 154 1 101 149 1 123 145 1 145 136 2 166 128 2 182 110 2 194 98 3 203 75 3 208 55 3 203 34 3 191 17 4 174 8 4 159 11 4 146 16 4 136 27 5 136 40 5 140 51 5 148 54 5 161 57]
)
(instance scumSoft of Rgn
	(properties)
	
	(method (init)
		(SL enable:)
		(super init: &rest)
		(= global56 0)
		(proc0_3)
		(Load rsVIEW 92)
		(Load rsVIEW 0)
		(Load rsVIEW 256)
		(Load rsVIEW 113)
		(Load rsVIEW 114)
		(Load rsVIEW 115)
		(Load rsSOUND 46)
		(Load rsSOUND 47)
		(Load rsSOUND 44)
		(Load rsSOUND 55)
		(Load rsSOUND 84)
		(Load rsSOUND 102)
		(Load rsSOUND 103)
		(jelloSound init:)
		(vaporizeSound init:)
		(if (not (== gGNorth 93))
			(gLongSong number: 102 loop: -1 play:)
		else
			(gLongSong stop:)
		)
		(announce state: global242)
		(if global233
			(if (== gNorth 90)
				(= global233 0)
				(= gShadowDroidX 0)
				(= gShadowDroidY 0)
			else
				(if
					(and
						(== 0 gShadowDroidX)
						(== gShadowDroidX gShadowDroidY)
					)
					(= gShadowDroidX 166)
					(= gShadowDroidY 97)
				)
				(User canInput: 0)
				(droidScript changeState: 1)
			)
		)
	)
	
	(method (doit)
		(if
		(and (not global233) (== 700 (Random 1 1400)))
			(announce cue:)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					(
						(Said
							'look[/area,department,deck,dirt,ceiling,left,right,up,down]'
						)
						(proc255_0 702 0)
					)
					((Said 'look/partition,partition') (proc255_0 702 1))
					((Said '*/cabinet,cabinet') (proc255_0 702 2))
					(
						(Said
							'converse,look/man,folk,bystander,eightprong,accountant'
						)
						(proc255_0 702 3)
					)
					((Said 'look/garbage,can,basket') (proc255_0 702 4))
					(
						(Said
							'look/chart,paper,passenger,calendar,board,desk,chair'
						)
						(proc255_0 702 5)
					)
					(
						(Said
							'sit,explore,get,beat,beat,get,feel/chart,passenger,calendar,board,chair,man,desk,paper,partition'
						)
						(proc255_0 702 6)
					)
				)
			)
		)
	)
)

(instance announce of Script
	(properties)
	
	(method (changeState newState)
		(++ global242)
		(switch (= state newState)
			(1 (proc255_0 702 7))
			(2 (proc255_0 702 8))
		)
	)
)

(class TrashBasket of Prop
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
		signal $0000
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
		cycleSpeed 0
		script 0
		cycler 0
		timer 0
		vaporized 0
		misses 0
		egoHere 0
		egoNear 0
		myNerd 0
		myID 0
		nearWest 0
		nearNorth 0
		nearEast 0
		nearSouth 0
	)
	
	(method (init)
		(self
			vaporized: [global567 myID]
			view: 115
			ignoreActors: 0
			setLoop: 4
			setCel: [global567 (super init:)]
			stopUpd:
		)
		(if (and vaporized myID) (self addToPic:))
	)
	
	(method (doit)
		(cond 
			(global233 (self egoNear: 0))
			(
				(and
					(<= nearWest (gEgo x?))
					(<= (gEgo x?) nearEast)
					(<= nearNorth (gEgo y?))
					(<= (gEgo y?) nearSouth)
				)
				(if
					(and
						(gEgo has: 12)
						(gEgo has: 13)
						(not vaporized)
						myNerd
					)
					(self egoNear: 1)
				)
			)
			((and egoNear (not vaporized) myNerd) (self egoNear: 0) (alertScript init: (self myNerd?)))
			(
				(and
					(not (gEgo mover?))
					(not global243)
					(not global233)
					myNerd
					(== 50 (Random 1 100))
				)
				(myNerd setCel: (if (myNerd cel?) 0 else 3))
				(if
				(and (not (== gGNorth 93)) (== 1 (Random 1 2)))
					(gLongSong
						number: (if (== 1 (Random 1 2)) 103 else 102)
						play:
					)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (gEgo has: 13)
					(cond 
						((Said 'look/garbage<mr') ((gInv at: 13) showSelf:))
						(
							(or
								(Said 'blast[/garbage]')
								(Said 'use/mrgarbage')
								(Said 'use/garbage<mr')
							)
							(if (self perform: egoIsHere species) (self egoHere: 1))
							(self vaporize:)
						)
						((Said 'blast/*') (proc255_0 702 9))
					)
				)
			)
		)
	)
	
	(method (cue)
		(cond 
			(egoHere
				(if vaporized
					(proc255_0 702 10)
				else
					(self
						vaporized: 1
						setCel: (= [global567 myID] 1)
						misses: 0
					)
					(cond 
						((not (== gGNorth 93)) (self addToPic:))
						((not myNerd) (proc255_0 702 11))
					)
				)
				(self egoHere: 0)
			)
			(egoNear
				(switch (++ misses)
					(1 (proc255_0 702 12))
					(2 (proc255_0 702 13))
					(3 (proc255_0 702 14))
					(4 (proc255_0 702 15))
					(5 (proc255_0 702 16))
					(6
						(if global233
							(-- misses)
						else
							(self egoNear: 0)
							(alertScript init: (self myNerd?))
						)
					)
				)
			)
			(else (proc255_0 702 17))
		)
		(gEgo view: 113 cycleSpeed: 0 setCycle: Walk)
		(proc0_3)
	)
	
	(method (vaporize)
		(proc0_2)
		(gEgo view: 114 setCel: 0 setCycle: End self)
		(vaporizeSound play:)
	)
)

(instance egoIsHere of Code
	(properties)
	
	(method (doit param1)
		(if global233 (return 0))
		(switch (gEgo loop?)
			(0
				(if
					(or
						(> (gEgo brTop?) (param1 brBottom?))
						(< (gEgo brBottom?) (param1 brTop?))
						(> (gEgo brRight?) (param1 brLeft?))
						(< (+ (gEgo brRight?) (gEgo xStep?)) (param1 brLeft?))
					)
					(return 0)
				)
			)
			(1
				(if
					(or
						(> (gEgo brTop?) (param1 brBottom?))
						(< (gEgo brBottom?) (param1 brTop?))
						(< (gEgo brLeft?) (param1 brRight?))
						(> (- (gEgo brLeft?) (gEgo xStep?)) (param1 brRight?))
					)
					(return 0)
				)
			)
			(2
				(if
					(or
						(< (gEgo brRight?) (param1 brLeft?))
						(> (gEgo brLeft?) (param1 brRight?))
						(> (gEgo brBottom?) (param1 nsTop?))
						(< (+ (gEgo brBottom?) (gEgo yStep?)) (param1 nsTop?))
					)
					(return 0)
				)
			)
			(3
				(if
					(or
						(< (gEgo brRight?) (param1 brLeft?))
						(> (gEgo brLeft?) (param1 brRight?))
						(< (gEgo brTop?) (param1 nsBottom?))
						(> (- (gEgo brTop?) (gEgo yStep?)) (param1 nsBottom?))
					)
					(return 0)
				)
			)
		)
		(return 1)
	)
)

(class Nerd of Prop
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
		signal $0000
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
		cycleSpeed 0
		script 0
		cycler 0
		timer 0
		seeProblem 0
		speakX 0
		speakY 0
		speakCel 0
	)
	
	(method (init)
		(super init:)
		(self view: 115 setCel: 0 stopUpd:)
	)
)

(class Fink of Act
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
		signal $0000
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
		cycleSpeed 0
		script 0
		cycler 0
		timer 0
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		moveSpeed 0
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		seeProblem 0
		speakX 0
		speakY 0
		speakCel 0
	)
	
	(method (init)
		(super init:)
		(self view: 115 xStep: 4 stopUpd:)
	)
	
	(method (doit)
		(super doit:)
		(if seeProblem
			(if global233
				(= seeProblem 0)
			else
				(alertScript init: self)
			)
		)
	)
)

(instance alertScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(= global233 1)
				(gEgo setMotion: 0)
				(= scriptClient (self client?))
				(alertBalloon init:)
				(gLongSong number: 84 loop: -1 play:)
				(= local1 5)
				(if (> (scriptClient loop?) 3)
					(self cue:)
				else
					(scriptClient setCycle: End self)
				)
			)
			(1
				(if (and (-- local1) (not (gEgo mover?)))
					(-- state)
					(Timer setReal: self 2)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> (scriptClient loop?) 3)
					(= cycles 1)
				else
					(scriptClient setCycle: Beg self)
				)
			)
			(3
				(scriptClient stopUpd:)
				(alertBalloon dispose:)
				(if (< (scriptClient loop?) 3) (proc255_0 702 18))
				(global2 setScript: droidScript)
			)
		)
	)
)

(instance alertBalloon of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			posn: (scriptClient speakX?) (scriptClient speakY?)
			view: 115
			setLoop: (if (== gGNorth 93) 9 else 5)
			setCel: (scriptClient speakCel?)
			setPri: 15
			stopUpd:
		)
	)
)

(instance shadowDroid of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 0
			view: 256
			setLoop: 2
			setCel: 1
			setCycle: Fwd
			xStep: (if (gEgo has: 12) 3 else 8)
			yStep: (if (gEgo has: 12) 2 else 5)
			ignoreHorizon: 1
			ignoreActors: 1
			ignoreControl: -1
		)
		(cond 
			(
				(and
					(== gShadowDroidX gShadowDroidY)
					(== gShadowDroidY 0)
				)
				(self
					posn: (+ (swoopDroid x?) 5) (+ (swoopDroid y?) 40)
				)
				(swoopDroid dispose:)
			)
			((or (== gNorth 90) (== gNorth 94)) (self posn: gShadowDroidX gShadowDroidY))
			(else
				(switch (gEgo loop?)
					(0
						(self
							posn:
								(if (>= gShadowDroidX 0)
									(- gShadowDroidX 320)
								else
									gShadowDroidX
								)
								gShadowDroidY
						)
					)
					(1
						(self
							posn:
								(if (<= gShadowDroidX 320)
									(+ gShadowDroidX 320)
								else
									gShadowDroidX
								)
								gShadowDroidY
						)
					)
					(2
						(self
							ignoreHorizon: 1
							posn:
								gShadowDroidX
								(if (>= gShadowDroidY 0)
									(- gShadowDroidY 190)
								else
									gShadowDroidY
								)
						)
					)
					(3
						(self
							posn:
								gShadowDroidX
								(if (<= gShadowDroidY 190)
									(+ gShadowDroidY 190)
								else
									gShadowDroidY
								)
						)
					)
				)
			)
		)
	)
)

(instance securityDroid of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri:
				(if
				(and (not (== gGNorth 93)) (< (gEgo y?) 116))
					14
				else
					15
				)
			view: 256
			setLoop: 1
			doit:
		)
	)
	
	(method (doit)
		(= gShadowDroidX (shadowDroid x?))
		(= gShadowDroidY (shadowDroid y?))
		(self
			posn: gShadowDroidX (- gShadowDroidY 40)
			setCel: (shadowDroid cel?)
		)
	)
)

(instance swoopDroid of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self setPri: 15 view: 256 setLoop: 0 ignoreActors: 1)
	)
	
	(method (doit)
		(if (not local2) (return))
		(if (and (<= 0 local3) (<= local3 62))
			(if (> local2 0)
				(self
					setCel: [local4 local3]
					x: [local4 (++ local3)]
					y: [local4 (++ local3)]
				)
				(++ local3)
			else
				(self
					y: [local4 local3]
					x: (- 320 [local4 (-- local3)])
					setCel: [local4 (-- local3)]
				)
				(-- local3)
			)
		else
			(= local2 0)
			(droidScript cue:)
		)
	)
)

(instance zapper of Prop
	(properties)
	
	(method (init)
		(super init:)
		(shadowDroid posn: (gEgo x?) (gEgo y?))
		(self
			setPri: (gEgo priority?)
			view: 256
			posn: (+ (shadowDroid x?) 1) (- (shadowDroid y?) 20)
			setLoop: 3
			setCycle: Fwd
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(if (gEgo has: 12)
			(gEgo
				view: (if cel 113 else 92)
				setLoop: (if cel 2 else 5)
				setCel: 0
			)
		else
			(gEgo view: (if cel 0 else 92) setLoop: 2 setCel: 0)
		)
	)
)

(instance droidScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local2 1)
				(= local3 0)
				(gLongSong number: 46 loop: 1 play:)
				(swoopDroid init:)
			)
			(1
				(gLongSong number: 47 loop: -1 play:)
				(shadowDroid init:)
				(securityDroid init:)
				(= local1 6)
				(self cue:)
			)
			(2
				(if
					(and
						(-- local1)
						(not (gEgo mover?))
						(== gShadowDroidX 166)
						(== gShadowDroidY 97)
					)
					(-- state)
					(Timer setReal: self 2)
				else
					(self cue:)
				)
			)
			(3
				(shadowDroid setMotion: Chase gEgo 0 self)
			)
			(4
				(if
					(or
						(& (gEgo onControl: -1) $0002)
						(>= (gEgo y?) 191)
						(>= (gEgo x?) 320)
					)
					(= state (- state 2))
				else
					(proc0_2)
				)
				(Timer setCycle: self 1)
			)
			(5
				(zapper init:)
				(jelloSound play:)
				(Timer setCycle: self 4)
			)
			(6
				(if (!= (jelloSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(zapper dispose:)
					(jelloSound stop:)
					(Timer setCycle: self 1)
				)
			)
			(7
				(gEgo
					view: 92
					setLoop: (if (gEgo has: 12) 5 else 2)
					setCycle: Fwd
					cycleSpeed: 2
				)
				(Timer setCycle: self 1)
			)
			(8
				(shadowDroid
					xStep: 6
					yStep: 4
					setMotion: MoveTo (- [local4 61] 3) (+ [local4 62] 40) self
				)
			)
			(9
				(securityDroid dispose:)
				(shadowDroid dispose:)
				(gLongSong number: 46 loop: 1 play:)
				(= local2 -1)
				(= local3 62)
				(swoopDroid init:)
			)
			(10
				(swoopDroid dispose:)
				(if (not (== gGNorth 93))
					(gLongSong number: 102 loop: -1 play:)
				)
				(= global233 0)
				(Timer setReal: self 6)
			)
			(11
				(gLongSong stop:)
				(proc0_17 901 0 7 (if (gEgo has: 12) 9 else 15))
			)
		)
	)
)

(instance jelloSound of Sound
	(properties
		number 44
		priority 3
	)
)

(instance vaporizeSound of Sound
	(properties
		number 55
		priority 2
	)
)
