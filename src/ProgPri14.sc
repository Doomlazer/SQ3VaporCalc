;;; Sierra Script 1.0 - (do not remove this comment)
(script# 93)
(include sci.sh)
(use Main)
(use Class_255_0)
(use TrashBasket)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm93 0
)

(instance rm93 of Rm
	(properties
		picture 93
		style $0000
		east 94
		south 91
	)
	
	(method (init)
		(super init:)
		(self setRegions: 702)
		(Load rsVIEW 131)
		(Load rsVIEW 132)
		(Load rsVIEW 133)
		(Load rsSOUND 54)
		(gAddToPics
			add:
				prog01
				prog02
				prog03
				prog04
				prog05
				prog06
				prog07
				prog08
				prog09
				prog10
				prog11
				prog12
				prog13
				prog14
				prog15
				prog16
				prog17
				prog18
				prog19
				prog20
				prog21
				prog22
				prog23
				prog24
				prog25
				prog26
		)
		(gAddToPics doit:)
		(rick init:)
		(ken init:)
		(trash1 init:)
		(gEgo init:)
		(if global232
			(= global232 0)
			(trash1 myNerd: 0)
			(if ((gInv at: 11) ownedBy: gGNorth) (keycard init:))
		else
			(= global232 1)
			(elmo init:)
			(trash1 setCel: (= [global567 0] 0))
			(trash1 vaporized: 0)
		)
		(self setScript: rmScript)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look[/area]') (if global232 (proc255_0 93 0) else (proc255_0 93 1)))
					((Said 'look/man,boss')
						(if (and global232 (gEgo inRect: 225 86 320 149))
							(proc255_0 93 2)
						else
							(proc255_0 93 3)
						)
					)
					((Said '*/complex') (proc255_0 93 4))
					((Said 'converse/man,boy,elmo,boss,bystander')
						(if (and global232 (gEgo inRect: 225 86 320 149))
							(proc255_0 93 5)
						else
							(proc255_0 93 6)
						)
					)
					((Said 'look,open,explore,unlock/desk,drawer')
						(if (gEgo inRect: 225 86 320 149)
							(cond 
								(global232 (proc255_0 93 7))
								(((gInv at: 11) ownedBy: gGNorth) (proc255_0 93 8))
								(else (proc255_0 93 9))
							)
						else
							(proc255_0 93 10)
						)
					)
					((Said 'get/key,card')
						(cond 
							(global232 (proc255_0 93 11))
							(((gInv at: 11) ownedBy: gGNorth)
								(if (gEgo inRect: 275 89 300 104)
									(gEgo get: 11)
									(keycard dispose:)
									(proc255_0 93 12)
									(gGame changeScore: 5)
								else
									(proc255_0 93 13)
								)
							)
							((gEgo has: 11) (proc255_0 93 14))
							(else (proc255_0 93 15))
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 94) (gLongSong stop:))
		(gTimers eachElementDo: #dispose 84)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(if (== gNorth 94) (gEgo posn: 318 65 view: 113))
		(gEgo init:)
		(if (== gNorth 94) (gEgo setMotion: MoveTo 288 65 self))
	)
	
	(method (doit)
		(super doit:)
		(if (not global233)
			(if
				(and
					(== (ken loop?) 0)
					(< (rick loop?) 2)
					(== 10 (Random 1 20))
				)
				(if (== (kenScript state?) 1)
					(kenScript start: 1)
				else
					(kenScript start: 0)
				)
				(ken setScript: kenWhip)
			)
			(if
				(and
					(== (rick loop?) 0)
					(< (ken loop?) 2)
					(== 10 (Random 1 20))
				)
				(if (== (rickScript state?) 0)
					(rickScript start: 0)
				else
					(rickScript start: 1)
				)
				(rick setScript: rickWhip)
			)
		)
	)
)

(instance trash1 of TrashBasket
	(properties
		nearWest 225
		nearNorth 86
		nearEast 320
		nearSouth 149
	)
	
	(method (init)
		(super init:)
		(self posn: 256 103 myNerd: elmo)
	)
)

(instance elmo of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 115
			setLoop: 8
			posn: 263 84
			setPri: 6
			speakX: 167
			speakY: 75
			speakCel: 0
		)
	)
)

(instance keycard of View
	(properties)
	
	(method (init)
		(self
			view: 115
			setLoop: 9
			setCel: 1
			setPri: 6
			posn: 285 92
		)
		(super init:)
	)
)

(class ProgPri14 of PV
	(properties
		y 0
		x 0
		z 0
		heading 0
		view 133
		loop 0
		cel 0
		priority 14
		signal $4000
	)
)

(class ProgPri4 of PV
	(properties
		y 0
		x 0
		z 0
		heading 0
		view 133
		loop 0
		cel 1
		priority 4
		signal $4000
	)
)

(class ProgPri2 of PV
	(properties
		y 0
		x 0
		z 0
		heading 0
		view 133
		loop 0
		cel 1
		priority 2
		signal $4000
	)
)

(instance prog01 of ProgPri14
	(properties
		y 181
		x 176
	)
)

(instance prog02 of ProgPri14
	(properties
		y 150
		x 175
	)
)

(instance prog03 of ProgPri14
	(properties
		y 118
		x 173
	)
)

(instance prog04 of ProgPri14
	(properties
		y 87
		x 171
	)
)

(instance prog05 of ProgPri14
	(properties
		y 54
		x 170
	)
)

(instance prog06 of ProgPri14
	(properties
		y 24
		x 170
	)
)

(instance prog07 of ProgPri14
	(properties
		y 181
		x 134
	)
)

(instance prog08 of ProgPri14
	(properties
		y 150
		x 138
	)
)

(instance prog09 of ProgPri14
	(properties
		y 118
		x 140
	)
)

(instance prog10 of ProgPri14
	(properties
		y 87
		x 141
	)
)

(instance prog11 of ProgPri14
	(properties
		y 55
		x 141
	)
)

(instance prog12 of ProgPri14
	(properties
		y 24
		x 143
	)
)

(instance prog13 of ProgPri4
	(properties
		y 181
		x 56
	)
)

(instance prog14 of ProgPri4
	(properties
		y 150
		x 63
	)
)

(instance prog15 of ProgPri4
	(properties
		y 118
		x 70
	)
)

(instance prog16 of ProgPri4
	(properties
		y 87
		x 78
	)
)

(instance prog17 of ProgPri4
	(properties
		y 55
		x 88
	)
)

(instance prog18 of ProgPri4
	(properties
		y 24
		x 96
	)
)

(instance prog19 of ProgPri2
	(properties
		y 181
		x 16
	)
)

(instance prog20 of ProgPri2
	(properties
		y 150
		x 26
	)
)

(instance prog21 of ProgPri2
	(properties
		y 118
		x 37
	)
)

(instance prog22 of ProgPri2
	(properties
		y 87
		x 48
	)
)

(instance prog23 of ProgPri2
	(properties
		y 55
		x 59
	)
)

(instance prog24 of ProgPri2
	(properties
		y 24
		x 72
	)
)

(instance prog25 of ProgPri2
	(properties
		y 24
		x 26
	)
)

(instance prog26 of ProgPri2
	(properties
		y 56
		x 10
	)
)

(instance rick of Act
	(properties)
	
	(method (init)
		(self
			ignoreHorizon: 1
			view: 131
			x: 116
			y: -5
			setPri: 14
			setCycle: Fwd
			setStep: 1 1
			ignoreActors: 1
			ignoreControl: -1
			setScript: rickScript
		)
		(super init:)
	)
)

(instance rickScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rick setLoop: 0 setMotion: MoveTo 97 148 self)
			)
			(1
				(rick setLoop: 1 setMotion: MoveTo 116 -5 self)
			)
			(2 (self init:))
		)
	)
)

(instance ken of Act
	(properties)
	
	(method (init)
		(self
			ignoreHorizon: 1
			view: 132
			x: -11
			y: 136
			setPri: 14
			setCycle: Fwd
			setStep: 1 1
			ignoreActors: 1
			ignoreControl: -1
			setScript: kenScript
		)
		(super init:)
	)
)

(instance kenScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ken setLoop: 1 setMotion: MoveTo 48 -5 self)
			)
			(1
				(ken setLoop: 0 setMotion: MoveTo -11 136 self)
			)
			(2
				(kenScript start: 0)
				(self init:)
			)
		)
	)
)

(instance rickWhip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rick
					setLoop: (if (<= 5 (Random 1 10)) 2 else 3)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
				(whipSound play:)
			)
			(1
				(if (!= (whipSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(rick setCycle: Fwd setLoop: 0 setScript: rickScript)
				)
			)
			(else  (self init:))
		)
	)
)

(instance kenWhip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ken setLoop: 2 setCel: 0 setMotion: 0 setCycle: End self)
				(whipSound play:)
			)
			(1
				(if (!= (whipSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(ken setCycle: Fwd setLoop: 0 setScript: kenScript)
				)
			)
			(else  (self init:))
		)
	)
)

(instance whipSound of Sound
	(properties
		number 54
		priority 1
	)
)
