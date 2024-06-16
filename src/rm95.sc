;;; Sierra Script 1.0 - (do not remove this comment)
(script# 95)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Wander)
(use Follow)
(use Chase)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm95 0
)

(local
	local0
)
(instance rm95 of Rm
	(properties
		picture 95
		style $0004
	)
	
	(method (init)
		(SL enable:)
		(proc0_3)
		(Load rsVIEW 901)
		(Load rsVIEW 126)
		(Load rsVIEW 127)
		(Load rsVIEW 128)
		(Load rsVIEW 210)
		(Load rsVIEW 113)
		(Load rsVIEW 114)
		(Load rsVIEW 88)
		(Load rsVIEW 116)
		(Load rsVIEW 118)
		(Load rsSOUND 44)
		(Load rsSOUND 45)
		(Load rsSOUND 48)
		(Load rsSOUND 50)
		(super init:)
		(self setScript: rmScript)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if (User canControl:)
			(if (>= (gEgo y?) 190)
				(global2 setScript: exitHallScript)
			)
			(cond 
				((& (= temp0 (gEgo onControl: -1)) $0010)
					(gEgo setPri: 5)
					(if
						(and
							(< 120 (gEgo x?))
							(< (gEgo x?) 200)
							(>= (gEgo loop?) 2)
						)
						(gEgo
							posn: (if (< (gEgo x?) 160) 120 else 200) (gEgo y?)
						)
					)
				)
				((& temp0 $0004) (gEgo setPri: 4))
				((& temp0 $0080) (gEgo setPri: 5))
				((& temp0 $0008)
					(if (!= (bridgeFront cel?) (bridgeFront lastCel:))
						(gEgo setPri: 5)
					else
						(return)
					)
				)
				(else (return))
			)
			(global2 setScript: gonner)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					(
					(or (Said 'look<down') (Said 'look/pit,deck,dirt')) (proc255_0 95 0))
					((Said 'look/pedestal,aisle,aisle,ramp') (proc255_0 95 1))
					((Said 'look/door,entrance') (proc255_0 95 2))
					((Said 'look/crack,crack') (proc255_0 95 3))
					((Said 'look/partition') (proc255_0 95 4))
					((or (Said 'look<up') (Said 'look/pane')) (proc255_0 95 5))
					((Said 'look/control,console,button') (proc255_0 95 6))
					((Said 'jump[/*]') (proc255_0 95 7))
					(
					(Said 'press,press,beat,feel,use/control,console,button')
						(if (gEgo inRect: 0 180 320 190)
							(gEgo setScript: buttonScript)
						else
							(proc255_0 95 8)
						)
					)
					((<= (captureScript state?) 3)
						(cond 
							((Said 'look[/area,left,right]') (proc255_0 95 9))
							((Said 'look,converse/man,folk') (proc255_0 95 10))
							((Said 'free,release/man[<2]') (proc255_0 95 11))
							((Said 'look/gel') (proc255_0 95 12))
							((Said 'melt/gel') (proc255_0 95 13))
							((Said 'eat/gel') (proc255_0 95 14))
							(
								(or
									(Said 'blast[/gel]')
									(Said 'use/mrgarbage')
									(Said 'use/garbage<mr')
								)
								(if
									(and
										(gEgo inRect: 140 102 176 110)
										(>= (gEgo loop?) 2)
									)
									(gEgo setScript: captureScript)
								else
									(proc255_0 95 15)
								)
							)
							((Said 'blast/*') (proc255_0 95 16))
							((Said '*/gel')
								(if (gEgo inRect: 140 102 176 110)
									(proc255_0 95 17)
								else
									(proc255_0 95 15)
								)
							)
						)
					)
					((Said 'look/gel') (proc255_0 95 18))
					((Said 'blast/gel') (proc255_0 95 19))
					((Said '*/gel') (proc255_0 95 20))
					((Said 'blast[/*]') (proc255_0 95 21))
					((Said 'attack,combat,escape') (proc255_0 95 22))
					((Said 'look[/area,left,right]') (proc255_0 95 23) (proc255_0 95 24))
					((Said '*/man<2') (proc255_0 95 25))
					((Said 'look/guard') (proc255_0 95 26))
					((>= (captureScript state?) 16)
						(cond 
							(
							(Said 'look/pane,man,guard,folk,accountant,eightprong') (proc255_0 95 27))
							((Said 'look/elmo,elmo,boy,(man<little)') (proc255_0 95 28))
							((Said 'converse/*') (proc255_0 95 29))
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gTimers eachElementDo: #dispose 84)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(mrMark init:)
		(mrScott init:)
		(doorLeft init:)
		(doorRear init:)
		(doorRight init:)
		(bridgeLeft init:)
		(bridgeFront init:)
		(bridgeRight init:)
		(windowLeft init:)
		(windowCenter init:)
		(windowRight init:)
		(elmoPug init:)
		(jelloSound init:)
		(fallSound init:)
		(doorSound init:)
		(bridgeSound init:)
		(machineSound init:)
		(gEgo init:)
		(gAddToPics add: progsLeft progsRear progsRight)
		(gAddToPics doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(machineSound play:)
				(gEgo
					view: 113
					posn: 158 190
					setCel: -1
					setLoop: -1
					ignoreActors: 0
					setStep: 3 2
					setPri: 7
					setMotion: MoveTo 158 188 self
				)
			)
			(1 (rm95 south: 90) (proc0_3))
		)
	)
)

(instance buttonScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(rm95 south: 0)
				(gEgo setMotion: MoveTo 125 188 self)
			)
			(1
				(gEgo setMotion: MoveTo 120 207 self)
			)
			(2
				(gEgo setMotion: MoveTo (- (gEgo x?) 1) (gEgo y?) self)
			)
			(3
				(if global238
					(= global238 0)
					(bridgeFront setCycle: Beg self)
				else
					(= global238 1)
					(bridgeFront setCycle: End self)
				)
				(bridgeSound play:)
			)
			(4
				(bridgeFront stopUpd:)
				(gEgo setMotion: MoveTo 158 (gEgo y?) self)
			)
			(5
				(gEgo setMotion: MoveTo 158 188 self)
			)
			(6 (rm95 south: 90) (proc0_3))
			(else  (self changeState: 0))
		)
	)
)

(instance gonner of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(captureScript changeState: 99)
				(gEgo
					view: 88
					ignoreActors: 1
					illegalBits: 0
					setStep: 3 12
					setLoop: (gEgo loop?)
					setCycle: End self
				)
			)
			(1
				(rm95 south: 0)
				(gEgo setCycle: 0 setMotion: MoveTo (gEgo x?) 220 self)
				(machineSound stop:)
				(fallSound play:)
			)
			(2
				(if (!= (fallSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(self cue:)
				)
			)
			(3 (proc0_17 901 0 0 10))
		)
	)
)

(instance exitHallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo (gEgo x?) 190 self)
			)
			(1
				(proc0_3)
				(global2 newRoom: 90)
			)
		)
	)
)

(instance captureScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(machineSound stop:)
				(jelloSound play:)
				(gEgo view: 114 setCel: 0 setCycle: End self)
			)
			(1
				(if (!= (jelloSound prevSignal?) -1)
					(-- state)
					(gEgo setCel: 0 setCycle: End self)
				else
					(jelloSound dispose:)
					(self cue:)
				)
			)
			(2
				(gEgo view: 113 setCycle: Walk)
				(mrMark
					view: 126
					setPri: (gEgo priority?)
					setLoop: -1
					setCel: -1
					setCycle: Walk
					observeControl: 28
					setMotion: Wander
				)
				(Timer setCycle: self 2)
			)
			(3
				(mrScott
					view: 127
					setPri: (gEgo priority?)
					setLoop: -1
					setCel: -1
					setCycle: Walk
					observeControl: 28
					setMotion: Wander
				)
				(= local0 global15)
				(= global15 global16)
				(gGame changeScore: -1)
				(proc0_3)
				(Timer setCycle: self 1)
			)
			(4
				(proc255_0 95 30)
				(proc255_0 95 31 67 -1 20 70 280)
				(proc255_0 95 32)
				(proc255_0 95 33 67 -1 20 70 280)
				(bridgeFront setCycle: Beg self)
				(bridgeSound play:)
			)
			(5
				(if (!= (bridgeSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(bridgeFront addToPic:)
					(self cue:)
				)
			)
			(6 (Timer setReal: self 10))
			(7
				(proc255_0 95 34 67 -1 20 70 280)
				(doorSound play:)
				(doorRear setCycle: End self)
			)
			(8
				(if (!= (doorSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRear stopUpd:)
					(self cue:)
				)
			)
			(9
				(doorSound play:)
				(doorLeft setCycle: End self)
			)
			(10
				(if (!= (doorSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorLeft stopUpd:)
					(self cue:)
				)
			)
			(11
				(guardLeft init:)
				(guardLeft setMotion: MoveTo 49 110 self)
			)
			(12
				(guardLeft stopUpd:)
				(doorSound play:)
				(doorRight setCycle: End self)
			)
			(13
				(if (!= (doorSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRight stopUpd:)
					(self cue:)
				)
			)
			(14
				(guardRight init:)
				(guardRight setMotion: MoveTo 271 110 self)
			)
			(15
				(guardRight stopUpd:)
				(windowLeft dispose:)
				(windowCenter dispose:)
				(windowRight dispose:)
				(Timer setReal: self 3)
			)
			(16
				(mrMark setLoop: 3 setCel: 0 setMotion: 0)
				(mrScott setLoop: 3 setCel: 0 setMotion: 0)
				(elmoPug setCycle: Fwd)
				(Timer setReal: self 5)
			)
			(17
				(elmoPug setCel: 1 forceUpd:)
				(proc255_0 95 35 67 -1 130 70 280)
				(proc255_0 95 36 67 -1 130 70 280)
				(proc255_0 95 37 67 -1 130 70 280)
				(elmoPug setCel: 0 addToPic:)
				(proc0_2)
				(= global15 local0)
				(gGame changeScore: 10)
				(fallSound dispose:)
				(bridgeLeft setCycle: End self)
				(bridgeSound play:)
			)
			(18
				(if (!= (bridgeSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(bridgeLeft addToPic:)
					(self cue:)
				)
			)
			(19
				(doorSound play:)
				(doorLeft setCycle: Beg self)
			)
			(20
				(if (!= (doorSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorLeft addToPic:)
					(self cue:)
				)
			)
			(21
				(guardLeft setMotion: MoveTo 90 110 self)
			)
			(22
				(mrMark
					setLoop: -1
					setCel: -1
					ignoreActors: 1
					ignoreControl: -1
					setMotion: Follow gEgo 2
				)
				(mrScott
					setLoop: -1
					setCel: -1
					ignoreActors: 1
					ignoreControl: -1
					setMotion: Follow mrMark 2
				)
				(guardLeft setMotion: Follow gEgo 30)
				(bridgeRight setCycle: End self)
				(bridgeSound play:)
			)
			(23
				(if (!= (bridgeSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(bridgeRight addToPic:)
					(self cue:)
				)
			)
			(24
				(gEgo
					setPri: 6
					ignoreActors: 1
					setMotion: MoveTo 205 110 self
				)
				(mrMark setPri: 6)
				(mrScott setPri: 6)
			)
			(25
				(guardRight setLoop: 1 setMotion: MoveTo 320 110)
				(gEgo setMotion: Follow guardRight 0)
				(guardLeft setMotion: Chase gEgo 0 self)
			)
			(26
				(guardRight dispose:)
				(guardLeft dispose:)
				(mrMark dispose:)
				(mrScott dispose:)
				(doorSound play:)
				(doorRight setCycle: Beg self)
			)
			(27
				(if (!= (doorSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRight addToPic:)
					(self cue:)
				)
			)
			(28
				(doorSound play:)
				(doorRear setCycle: Beg self)
			)
			(29
				(if (!= (doorSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(doorRear addToPic:)
					(doorSound dispose:)
					(self cue:)
				)
			)
			(30
				(windowLeft init:)
				(windowCenter init:)
				(windowRight init:)
				(Timer setReal: self 1)
			)
			(31
				(gEgo put: 12 -1 put: 13 -1 put: 11 -1 put: 15 -1)
				(global2 newRoom: 121)
			)
		)
	)
)

(instance bridgeLeft of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 4
			view: 118
			loop: 1
			cel: 0
			posn: 84 121
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance bridgeFront of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 6
			view: 118
			loop: 0
			cel: (if global238 6 else 0)
			posn: 160 180
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance bridgeRight of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 4
			view: 118
			loop: 2
			cel: 0
			posn: 233 121
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance doorLeft of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 3
			view: 118
			loop: 4
			cel: 0
			posn: 54 125
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance doorRear of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 3
			view: 118
			loop: 3
			cel: 0
			posn: 159 84
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance doorRight of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 3
			view: 118
			loop: 5
			cel: 0
			posn: 266 124
			ignoreActors: 1
			stopUpd:
		)
	)
)

(instance windowLeft of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 5
			view: 116
			loop: 0
			cel: 0
			posn: 80 32
			stopUpd:
		)
	)
)

(instance windowCenter of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 5
			view: 116
			loop: 0
			cel: 1
			posn: 160 26
			stopUpd:
		)
	)
)

(instance windowRight of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 5
			view: 116
			loop: 0
			cel: 2
			posn: 239 32
			stopUpd:
		)
	)
)

(instance progsLeft of PV
	(properties
		y 30
		x 61
		view 116
		loop 1
	)
)

(instance progsRear of PV
	(properties
		y 21
		x 152
		view 116
		loop 1
		cel 1
	)
)

(instance progsRight of PV
	(properties
		y 29
		x 251
		view 116
		loop 1
		cel 2
	)
)

(instance guardLeft of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			ignoreControl: 1
			setPri: 6
			view: 210
			setLoop: 1
			cel: 0
			posn: 10 110
			setCycle: Walk
		)
	)
)

(instance elmoPug of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 4
			view: 116
			loop: 2
			cel: 0
			posn: 156 27
			stopUpd:
		)
	)
)

(instance guardRight of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			ignoreControl: 1
			setPri: 6
			view: 210
			setLoop: 0
			cel: 0
			posn: 300 110
			setCycle: Walk
		)
	)
)

(instance mrMark of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 128
			setLoop: 0
			setCel: 0
			posn: 148 106
			setPri: 7
			setCycle: Fwd
		)
	)
)

(instance mrScott of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 128
			setLoop: 1
			setCel: 2
			posn: 169 106
			setPri: 7
			setCycle: Fwd
		)
	)
)

(instance jelloSound of Sound
	(properties
		number 44
		priority 1
	)
)

(instance fallSound of Sound
	(properties
		number 45
		priority 2
	)
)

(instance doorSound of Sound
	(properties
		number 48
		priority 1
	)
)

(instance bridgeSound of Sound
	(properties
		number 48
		priority 1
	)
)

(instance machineSound of Sound
	(properties
		number 50
		loop -1
	)
)
