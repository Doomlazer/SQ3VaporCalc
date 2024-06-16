;;; Sierra Script 1.0 - (do not remove this comment)
(script# 13)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm013 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)
(instance rm013 of Rm
	(properties
		picture 13
		style $0000
		horizon 10
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(Load rsSCRIPT 991)
		(= local3 991)
		(Load rsVIEW 17)
		(Load rsVIEW 26)
		(Load rsVIEW 752)
		(Load rsVIEW 852)
		(Load rsVIEW 10)
		(Load rsVIEW 289)
		(if (== gGGGGNorth 3)
			(Load rsVIEW 260)
			(Load rsVIEW 261)
		else
			(Load rsVIEW 22)
			(Load rsVIEW 23)
		)
		(Load rsSOUND 35)
		(Load rsSOUND 45)
		(Load rsSOUND 52)
		(Load rsSOUND 53)
		(if (not gGEgoX_2) (= gGEgoX_2 226))
		(if (!= gNorth 12) (= global132 3))
		(super init:)
		(bot init:)
		(proc0_3)
		(gEgo setStep: -1 1)
		(if (== global132 3)
			(gEgo
				view: 0
				posn: 304 111
				setStep: 3
				setPri: 9
				init:
				setScript: railWalkScript
			)
			(grabber
				loop: (if (== gGGGGNorth 3) 1 else 0)
				setStep: 3 1
				posn: gGEgoX_2 104
				init:
				stopUpd:
			)
		else
			(gEgo setScript: grabScript)
		)
	)
	
	(method (doit)
		(if
			(and
				(not local2)
				(or
					(gEgo inRect: 35 103 260 105)
					(gEgo inRect: 143 74 237 78)
					(== global132 6)
				)
			)
			(= local2 15)
		)
		(if
			(and
				(> local2 2)
				(not (gEgo inRect: 35 103 260 105))
				(not (gEgo inRect: 143 74 237 78))
				(!= global132 6)
			)
			(= local2 0)
		)
		(if (and (> local2 2) global219) (-- local2))
		(if
		(and (== (bot script?) botPanelScript) (== local2 2))
			(= local2 1)
			(cond 
				(
				(or (gEgo inRect: 35 103 260 105) (== global132 6)) (bot setScript: frontZapScript))
				((gEgo inRect: 143 74 237 78) (bot setScript: backZapScript))
				(else (= local2 0))
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evMOUSEBUTTON
				(if
					(and
						(not global155)
						(== (User controls?) 1)
						(!= global132 6)
					)
					(gEgo
						setMotion:
							MoveTo
							(cond 
								((< (pEvent x?) 30) -30)
								((> (pEvent x?) 295) 330)
								(else (pEvent x?))
							)
							(gEgo y?)
					)
					(pEvent claimed: 1)
				)
			)
			(evSAID
				(if (Said 'look>')
					(cond 
						((Said '/android') (proc255_0 13 0))
						((Said '/comp,console,(device<monitoring)') (proc255_0 13 1))
						((Said '/device,grabber,console[<control]')
							(if (or (== global132 4) (== global132 5))
								(proc255_0 13 2)
							else
								(proc255_0 13 3)
							)
						)
						((Said '/motivator,artifact')
							(if (== gGGGGNorth 3)
								(if (or (== global132 4) (== global132 5))
									(proc255_0 13 4)
								else
									(proc255_0 13 5)
								)
							else
								(proc255_0 13 6)
							)
						)
						((Said 'look/throttle,control,stick')
							(if (or (== global132 4) (== global132 5))
								(proc255_0 13 7)
							else
								(proc255_0 13 8)
							)
						)
						((Said '/claw[<grabber]')
							(if (== global132 6)
								(proc255_0 13 9)
							else
								(proc255_0 13 4)
							)
						)
						((Said '/chair[<grabber,device]')
							(if (or (== global132 4) (== global132 5))
								(proc255_0 13 10)
							else
								(proc255_0 13 11)
							)
						)
						((Said '/system,pedestal,bin') (if global133 (proc255_0 13 12) else (proc255_0 13 13)))
						((Said '/banister,banister') (proc255_0 13 14))
						((Said 'look/partition') (proc255_0 13 15))
						((Said '[<at,around,in][/area,!*]')
							(if (or (== global132 4) (== global132 5))
								(proc255_0 13 16)
							else
								(proc255_0 13 17)
							)
						)
						((Said '/lamp<grabber,device,safety')
							(if (or (== global132 4) (== global132 5))
								(proc255_0 13 18)
							else
								(proc255_0 13 19)
							)
						)
						(
							(or
								(Said '[<down]/dirt,deck')
								(Said '<down[/dirt,deck]')
							)
							(proc255_0 13 20)
						)
						(
							(or
								(Said '[<up,above]/ceiling')
								(Said '<up,above[/ceiling]')
							)
							(proc255_0 13 21)
						)
					)
				)
				(if (Said 'holler,converse/android') (proc255_0 13 22))
				(if (Said 'beat,attack/android') (proc255_0 13 23))
				(if
					(or
						(Said 'climb[<up][/grabber,device]')
						(Said 'climb/banister,banister<up<to')
						(Said 'climb<up,on/banister,banister')
					)
					(proc255_0 13 24)
				)
				(if (Said 'enter,(go<in,in)/system') (proc255_0 13 25))
				(if
					(or
						(Said 'enter,board[/device,grabber,chair]')
						(Said 'get<on,in,onto,down/[device,grabber,chair]')
						(Said 'climb[<on,in,onto,in,down][/device,grabber,chair]')
					)
					(cond 
						((or (== global132 5) (== global132 4)) (proc255_0 13 26))
						((gEgo inRect: gGEgoX_2 110 (+ gGEgoX_2 40) 116) (gEgo setScript: ontoGrabScript))
						((== global132 6) (gEgo setScript: grabScript))
						(else (proc255_0 13 27))
					)
				)
				(if
					(or
						(Said
							'drag,press,use,manipulate,go[<forward,backward,back][/stick,throttle,control,knob]'
						)
						(Said
							'begin,manipulate,drive[<forward,backward,back]/grabber,device'
						)
					)
					(proc255_0 13 28)
				)
				(if
					(Said
						'disembark,(stand[<up]),(climb,get<off,out)[/grabber,device,claw,!*]'
					)
					(if (or (== global132 5) (== global132 4))
						(cond 
							((gEgo mover?) (proc255_0 13 29))
							((gEgo inRect: 126 103 154 107) (gEgo setScript: platformScript))
							(else (proc255_0 13 30))
						)
					else
						(proc255_0 13 31)
					)
				)
			)
			(evJOYSTICK
				(if
				(or global155 (and (!= global132 4) (!= global132 5)))
					(return)
				)
				(switch (pEvent message?)
					(JOY_UP
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_DOWN
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_UPLEFT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_UPRIGHT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_DOWNRIGHT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_DOWNLEFT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= local0 3)
			(if (== newRoomNumber 15) (gLongSong fade:))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance botPanelScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bot setLoop: 0 cel: 0 cycleSpeed: 4 setCycle: End self)
			)
			(1
				(bot cel: 0)
				(= seconds (Random 7 12))
			)
			(2 (self changeState: 0))
		)
	)
)

(instance frontZapScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bot cycleSpeed: 0 setCycle: End self)
			)
			(1 (= cycles 15))
			(2
				(bot setLoop: 1 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(3
				(bot
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 165 127 self
				)
			)
			(4
				(bot
					cel: 255
					loop:
						(cond 
							((== global132 6) 3)
							((< (gEgo x?) (- (bot x?) 20)) 1)
							((> (gEgo x?) (+ (bot x?) 45)) 2)
							(else 3)
						)
					setCycle: Beg self
				)
			)
			(5 (= seconds 3))
			(6
				(if
					(and
						(== local2 1)
						(or
							(gEgo inRect: 35 103 260 105)
							(and (== global132 6) (== (gEgo view?) 0))
						)
					)
					(bot
						cel: 0
						loop:
							(cond 
								((== global132 6) 7)
								((< (gEgo x?) (- (bot x?) 20)) 4)
								((> (gEgo x?) (+ (bot x?) 45)) 5)
								(else 7)
							)
						setCycle: End self
					)
					(zotSound play:)
				else
					(bot cel: 0 setCycle: End self)
				)
			)
			(7
				(if (> (bot loop?) 2)
					(if
						(and
							(== local0 0)
							(or (gEgo inRect: 35 103 260 105) (== global132 6))
						)
						(= local0 3)
						(proc0_2)
						(if (== global132 4)
							(grabber
								view: 752
								loop: (if (== gGGGGNorth 3) 1 else 0)
								posn: (gEgo x?) (gEgo y?)
								setMotion: 0
								init:
							)
						)
						(gEgo hide:)
						(zot
							x: (if (!= global132 6) (+ (gEgo x?) 11) else (gEgo x?))
							y: (if (!= global132 6)
								(+ (gEgo y?) 45)
							else
								(- (gEgo y?) 6)
							)
							init:
						)
					)
					(= cycles 15)
					(ShakeScreen 5)
				else
					(= cycles 2)
				)
			)
			(8
				(if (gCast contains: zot)
					(zot dispose:)
					(proc0_10)
					(gEgo dispose:)
					(proc255_0 13 32)
					(proc0_17 901 0 10 14)
				else
					(bot
						setLoop: 3
						setCycle: Walk
						setMotion: MoveTo 165 109 self
					)
				)
			)
			(9
				(bot setLoop: 1 cel: 255 setCycle: Beg self)
			)
			(10
				(= local2 0)
				(bot setScript: botPanelScript)
			)
		)
	)
)

(instance backZapScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bot cycleSpeed: 0 setCycle: End self)
			)
			(1 (= seconds 2))
			(2
				(bot setLoop: 9 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(3
				(bot
					setLoop: 8
					setCycle: Walk
					setMotion: MoveTo 192 100 self
				)
			)
			(4 (= seconds 3))
			(5
				(if
				(and (== local2 1) (gEgo inRect: 143 74 237 78))
					(proc0_2)
					(bot cel: 0 setCycle: End self)
					(zotSound play:)
				else
					(bot setCycle: Walk setMotion: MoveTo 165 109 self)
				)
			)
			(6
				(if (< (bot y?) 105)
					(grabber
						view: 752
						posn: (gEgo x?) (gEgo y?)
						setLoop: (if (== gGGGGNorth 3) 3 else 2)
						init:
						setPri: (gEgo priority?)
						setMotion: 0
					)
					(gEgo hide:)
					(zot posn: (+ (gEgo x?) 7) (+ (gEgo y?) 24) init:)
					(ShakeScreen 5)
					(= cycles 15)
				else
					(bot setLoop: 9 cel: 255 setCycle: Beg self)
				)
			)
			(7
				(if (gCast contains: zot)
					(zot dispose:)
					(proc0_10)
					(gEgo dispose:)
					(proc255_0 13 32)
					(proc0_17 901 0 10 14)
				else
					(bot setLoop: 0 cel: 0 setScript: botPanelScript)
					(= local2 0)
				)
			)
		)
	)
)

(instance railWalkScript of Script
	(properties)
	
	(method (doit)
		(cond 
			(
				(and
					(== (gEgo view?) 0)
					(!= (gEgo onControl: 1) 16384)
				)
				(self changeState: 1)
				(proc0_2)
				(= global100 1)
			)
			((> (gEgo x?) 316) (gEgo setMotion: 0) (global2 newRoom: 12))
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (gEgo setLoop: -1))
			(1
				(gEgo
					view: 17
					setLoop: (gEgo loop?)
					cel: 0
					x: (if (< (gEgo x?) 22) 22 else (gEgo x?))
					setMotion: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(2
				(gEgo
					setPri: (if (< (gEgo y?) 113) 8 else 9)
					setStep: 3 20
					setMotion: MoveTo (gEgo x?) 220 self
				)
				(gLongSong number: 45 loop: 1 play:)
			)
			(3
				(= local4 (proc255_0 13 33 91))
				(= seconds 5)
			)
			(4
				(proc0_12)
				(proc0_17 901 0 0 1)
			)
		)
	)
)

(instance ontoGrabScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global100 1)
				(proc0_2)
				(if (== global132 3)
					(gEgo
						view: 289
						posn: (+ gGEgoX_2 7) (gEgo y?)
						cel: 0
						setMotion: 0
						cycleSpeed: 2
						setCycle: End self
					)
				else
					(self changeState: 2)
				)
			)
			(1 (= cycles 5))
			(2
				(grabber dispose:)
				(proc0_3)
				(gEgo setScript: grabScript)
				(= global100 0)
			)
		)
	)
)

(instance grabScript of Script
	(properties)
	
	(method (doit)
		(if (not global155)
			(cond 
				((not (gEgo mover?))
					(cond 
						((and (== global132 4) (!= (gEgo loop?) 0)) (gEgo loop: 0))
						((and (== global132 5) (!= (gEgo loop?) 1)) (gEgo loop: 1))
					)
					(if (== (gLongSong state?) 3) (gLongSong stop:))
				)
				((== global132 4)
					(cond 
						(
							(and
								(== (gEgo loop?) 0)
								(or
									(!= (gLongSong number?) 52)
									(!= (gLongSong state?) 3)
								)
							)
							(gLongSong stop: number: 52 play:)
						)
						(
							(and
								(== (gEgo loop?) 1)
								(or
									(!= (gLongSong number?) 53)
									(!= (gLongSong state?) 3)
								)
							)
							(gLongSong stop: number: 53 play:)
						)
					)
				)
				((== global132 5)
					(cond 
						(
							(and
								(== (gEgo loop?) 1)
								(or
									(!= (gLongSong number?) 52)
									(!= (gLongSong state?) 3)
								)
							)
							(gLongSong stop: number: 52 play:)
						)
						(
							(and
								(== (gEgo loop?) 0)
								(or
									(!= (gLongSong number?) 53)
									(!= (gLongSong state?) 3)
								)
							)
							(gLongSong stop: number: 53 play:)
						)
					)
				)
			)
		)
		(if (not global100)
			(if (== global132 4)
				(if (< (gEgo x?) -8)
					(= global100 1)
					(proc0_2)
					(self changeState: 2)
				)
				(if (> (gEgo x?) 316)
					(gEgo setMotion: 0)
					(global2 newRoom: 12)
				)
			)
			(if (== global132 5)
				(if (< (gEgo x?) 132)
					(= global100 1)
					(proc0_2)
					(self changeState: 6)
				)
				(if (> (gEgo x?) 255)
					(gEgo setMotion: 0)
					(global2 newRoom: 12)
				)
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 5)
					(gEgo
						view: (if (== gGGGGNorth 3) 261 else 23)
						setPri: 7
						posn: 242 76
						setStep: 2 1
						init:
						setMotion: MoveTo -40 76
					)
					(User prevDir: 7)
				else
					(gEgo setStep: 3 1 setPri: 9 y: 104)
					(if (== global132 4)
						(gEgo x: 313 init: setMotion: MoveTo -40 (gEgo y?))
						(User prevDir: 7)
					else
						(gEgo
							view: (if (== gGGGGNorth 3) 260 else 22)
							loop: 0
							cel: 0
						)
						(if (== global132 6)
							(gEgo x: (grabber x?))
							(grabber dispose:)
						else
							(gEgo x: gGEgoX_2)
						)
						(= global132 4)
					)
				)
				(gEgo setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(if (< (gEgo x?) 230) (proc255_0 13 34))
			)
			(2
				(proc0_2)
				(User canControl: 0 canInput: 1)
				(gEgo
					view: 26
					setPri: 7
					setLoop: (if (!= gGGGGNorth 3) 2 else 5)
					illegalBits: 0
					posn: -9 102
					setStep: 1 2
					setMotion: MoveTo -9 96 self
				)
			)
			(3
				(gEgo
					setLoop: (if (!= gGGGGNorth 3) 1 else 4)
					posn: -6 94
					setStep: 5 1
					setMotion: MoveTo 59 81 self
				)
			)
			(4
				(gEgo
					view: (if (== gGGGGNorth 3) 261 else 23)
					setPri: -1
					setLoop: -1
					loop: 0
					setStep: 2 1
					posn: 132 76
					illegalBits: -32768
				)
				(= seconds 2)
			)
			(5
				(gEgo setMotion: MoveTo 321 76)
				(= global100 0)
				(proc0_3)
				(= global132 5)
				(User prevDir: 3)
			)
			(6
				(proc0_2)
				(User canControl: 0 canInput: 1)
				(= seconds 2)
			)
			(7
				(gEgo
					view: 26
					setLoop: (if (!= gGGGGNorth 3) 0 else 3)
					setStep: 5 1
					posn: 59 81
					setMotion: MoveTo -6 94 self
				)
			)
			(8
				(gEgo
					setLoop: (if (!= gGGGGNorth 3) 2 else 5)
					posn: -9 96
					setStep: 1 2
					setMotion: MoveTo -9 102 self
				)
			)
			(9
				(gEgo
					view: (if (== gGGGGNorth 3) 260 else 22)
					setLoop: -1
					loop: 0
					setPri: 9
					setStep: 3 1
					illegalBits: -32768
					posn: -8 104
					setMotion: MoveTo 322 104
				)
				(proc0_3)
				(= global132 4)
				(= global100 0)
				(User prevDir: 3)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 100])
		(super handleEvent: pEvent)
		(if
			(or
				(!= (pEvent type?) evSAID)
				global100
				(pEvent claimed?)
			)
			(return)
		)
		(if
			(or
				(Said 'lower/claw[<grabber]')
				(Said 'use,press,press/claw,button')
			)
			(proc255_0 13 35)
		)
	)
)

(instance platformScript of Script
	(properties)
	
	(method (doit)
		(if global100 (return))
		(super doit:)
		(if
			(or
				(== (gEgo onControl: 0) 5)
				(gEgo inRect: 99 168 190 172)
			)
			(self changeState: 1)
			(= global100 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gGEgoX_2 (gEgo x?))
				(grabber x: (gEgo x?) y: (gEgo y?) init:)
				(= gGEgoX_2 (gEgo x?))
				(gEgo
					view: 0
					loop: 2
					posn: 154 152
					setPri: 14
					cycleSpeed: 0
					setMotion: 0
					setCycle: Walk
					setStep: 3 2
				)
				(= global132 6)
			)
			(1
				(proc0_2)
				(gEgo
					view: 17
					setLoop: (gEgo loop?)
					cel: 0
					illegalBits: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(2
				(if (!= local0 3)
					(= local0 1)
					(gEgo setCycle: 0)
					(if (gEgo inRect: 99 168 190 172)
						(gEgo setStep: 3 20 setMotion: MoveTo 148 229 self)
					else
						(gEgo
							setPri: 9
							setStep: 5 20
							setMotion: MoveTo (gEgo x?) 230 self
						)
						(self state: 4)
					)
					(gLongSong number: 45 loop: 1 play:)
				)
			)
			(3
				(gEgo hide:)
				(Timer setCycle: self 2)
			)
			(4
				(if (not global133) (gGame changeScore: 5))
				(global2 newRoom: 15)
			)
			(5
				(proc255_0 13 36)
				(proc0_17 901 0 0 1)
			)
		)
	)
)

(instance grabber of Act
	(properties
		view 752
	)
	
	(method (init)
		(super init:)
		(self setStep: 3 1 setPri: 9 ignoreActors: 1)
	)
)

(instance bot of Act
	(properties
		view 10
	)
	
	(method (init)
		(super init:)
		(self
			cel: 0
			loop: 0
			posn: 165 109
			setPri: 8
			illegalBits: 0
			ignoreActors: 1
			setScript: botPanelScript
		)
	)
)

(instance zot of View
	(properties
		view 10
	)
	
	(method (init)
		(super init:)
		(self loop: 6 ignoreActors: 1 setPri: 15)
	)
)

(instance zotSound of Sound
	(properties
		number 35
		priority 1
	)
)
