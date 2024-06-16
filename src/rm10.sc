;;; Sierra Script 1.0 - (do not remove this comment)
(script# 10)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Jump)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm10 0
)

(local
	newProp
	local1
	local2
	local3
)
(instance grind of Sound
	(properties
		number 43
		priority 1
		loop -1
	)
)

(instance rm10 of Rm
	(properties
		picture 10
		style $0000
		horizon 10
		east 11
		west 9
	)
	
	(method (init &tmp [temp0 50])
		(self setLocales: 703)
		(User canInput: 1 canControl: 0)
		(Load rsVIEW 750)
		(Load rsVIEW 20)
		(Load rsSOUND 42)
		(Load rsSOUND 43)
		(cond 
			((== global132 4) (Load rsVIEW 22) (Load rsVIEW 258) (Load rsVIEW 260))
			((== global132 5) (Load rsVIEW 23) (Load rsVIEW 259) (Load rsVIEW 261))
			(else
				(Load rsSCRIPT 991)
				(= local3 991)
				(Load rsVIEW 0)
				(Load rsVIEW 17)
				(Load rsVIEW 24)
			)
		)
		(if (and (!= gNorth 9) (!= gNorth 11))
			(= global132 2)
		)
		(cond 
			((== global132 3) (proc0_3) (gEgo init: setScript: railJump))
			((== global132 2)
				(gEgo
					view: 750
					posn: 2 145
					setStep: 3 1
					setLoop: 1
					setCel: 2
					setPri: 8
					init:
					setCycle: 0
				)
			)
			((or (== global132 5) (== global132 4)) (gEgo setScript: grabScript))
		)
		(if (or (> global124 0) (== global132 2))
			(pile1 init:)
			(fallPile init:)
			(shredder init:)
			(gLongSong number: 42 loop: -1 priority: 0 play:)
		else
			(shredder init: addToPic:)
		)
		(super init:)
		(self setScript: rmScript)
	)
	
	(method (dispose)
		(if (== global132 3) (DisposeScript 991))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (or (pEvent claimed?) (> global100 1)) (return))
		(switch (pEvent type?)
			(evMOUSEBUTTON
				(if (and (not global155) (== (User controls?) 1))
					(gEgo setMotion: MoveTo (pEvent x?) (gEgo y?))
					(pEvent claimed: 1)
				)
			)
			(evSAID
				(cond 
					((Said 'look>')
						(cond 
							((Said '/conveyer,belt')
								(if (and (== global124 0) (!= global132 2))
									(proc255_0 10 0)
								else
									(proc255_0 10 1)
								)
							)
							((Said '/iron,debris,scrap,heap')
								(if (gCast contains: shredder)
									(proc255_0 10 2)
								else
									(proc255_0 10 3)
								)
							)
							((Said '/tackle,post,device')
								(if (== global124 0)
									(proc255_0 10 4)
								else
									(proc255_0 10 5)
								)
							)
							((Said '/conduit') (proc255_0 10 6))
							((Said '[<at,around,in][/area,!*]')
								(cond 
									((== global132 3) (proc255_0 10 7))
									((== global132 2) (proc255_0 10 8))
									(else (proc255_0 10 9))
								)
							)
						)
					)
					(
						(Said
							'climb,descend,(climb[<up,down,on,onto])/conduit,sheet[<iron]'
						)
						(proc255_0 10 10)
					)
					(
					(Said 'jump,leap,(get,climb<on,onto)[<off]/conveyer,belt')
						(if (== global132 2)
							(proc255_0 10 11)
						else
							(proc255_0 10 12)
						)
					)
					((Said '(get<up),stand[<up][/belt,conveyer]')
						(if (== global132 2)
							(if (!= (gEgo view?) 0)
								(proc0_3)
								(gEgo
									view: 0
									setLoop: -1
									loop: 0
									setCycle: Walk
									setMotion: 0
									setStep: 3 1
								)
							else
								(proc255_0 10 13)
							)
						else
							(pEvent claimed: 0)
							(return)
						)
					)
					((Said 'get/banister')
						(if (== global132 2)
							(proc255_0 10 14)
						else
							(proc255_0 10 15)
						)
					)
					(
					(Said 'jump,leap,climb[<onto,on,to,up,down]/conduit') (proc255_0 10 16))
					(
					(and (== global132 2) (Said 'climb<up,onto/banister')) (proc255_0 10 14))
					(
						(Said
							'jump,leap[<to,onto,on,up,down,off][/banister,banister]'
						)
						(if (== global132 2)
							(if (== (gEgo view?) 0)
								(gEgo setScript: railJump)
							else
								(proc255_0 10 17)
							)
						else
							(pEvent claimed: 0)
							(return)
						)
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
		(if (!= global132 2)
			(gLongSong stop:)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance newPileScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(fallPile setCycle: End self)
			)
			(1
				(pile1
					setCel: (Random 0 1)
					posn: -32 145
					show:
					setMotion: MoveTo 175 145 self
				)
			)
			(2
				(pile1 hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (doit)
		(if (and (== global132 2) (> (gEgo x?) 174))
			(User canControl: 0 canInput: 0)
		)
		(if
			(and
				(== global100 0)
				(== (rmScript state?) 0)
				(== (gEgo view?) 0)
				(== global132 2)
			)
			(gEgo posn: (+ (gEgo x?) 3) (gEgo y?))
			(if (> (gEgo x?) 182)
				(rmScript changeState: 1)
				(return)
			)
			(if (or (< (gEgo y?) 141) (> (gEgo y?) 147))
				(gEgo setScript: faller)
				(return)
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 2)
					(gEgo setMotion: MoveTo 184 145 self)
				)
			)
			(1
				(proc0_2)
				(= global100 1)
				(gEgo
					setStep: 5 5
					setPri: 9
					setCycle: 0
					setMotion: JumpTo 199 162 self
				)
			)
			(2
				(gEgo hide:)
				(grind play:)
				((= newProp (Prop new:))
					view: 20
					setLoop: 1
					posn: 203 176
					setPri: 15
					init:
					setCycle: Fwd
					ignoreActors: 1
				)
				(= seconds 3)
			)
			(3
				(newProp dispose:)
				(grind fade:)
				(= cycles 5)
			)
			(4
				(= local2 (proc255_0 10 18 91))
				(= seconds 6)
			)
			(5
				(proc0_12)
				(proc0_17 901 0 3 4)
			)
		)
	)
)

(instance railJump of Script
	(properties)
	
	(method (doit)
		(if
		(and (not global100) (!= (gEgo onControl: 0) 16384))
			(gEgo setScript: faller)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 3)
					(if (== gNorth 9) (gEgo x: 4))
				else
					(proc0_2)
					(= global100 1)
					(gEgo
						setMotion: 0
						view: 24
						setLoop: 0
						cel: 0
						cycleSpeed: 1
						illegalBits: -32768
						setCycle: End self
					)
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setPri: 9 posn: (gEgo x?) 144)
				(= seconds 2)
			)
			(2
				(gEgo cycleSpeed: 2 setCycle: End self)
			)
			(3
				(gEgo
					setLoop: 2
					setCel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(4
				(gEgo
					setLoop: 3
					setCel: 0
					posn: (gEgo x?) 122
					setCycle: End self
				)
			)
			(5
				(gEgo
					view: 0
					posn: (+ (gEgo x?) 9) 123
					setLoop: -1
					loop: 1
					setCycle: Walk
					cycleSpeed: 0
					setDirection: 0
				)
				(proc0_3)
				(if (not global241)
					(= global241 1)
					(gGame changeScore: 10)
				)
				(= global132 3)
				(= global100 0)
			)
			(6 (= global132 3))
		)
	)
)

(instance faller of Script
	(properties)
	
	(method (doit)
		(if (and (< (gEgo loop?) 11) (> (gEgo y?) 147))
			(gEgo setPri: 11)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global100 1)
				(gEgo
					view: 17
					setLoop: (gEgo loop?)
					cel: 0
					illegalBits: 0
					setCycle: End self
					setMotion: 0
					cycleSpeed: 2
				)
				(if (== global132 2)
					(gEgo setPri: (if (< (gEgo y?) 141) 4 else 10))
				else
					(gEgo setPri: (if (< (gEgo y?) 125) 8 else 9))
				)
			)
			(1
				(gEgo
					setStep: 1 15
					setMotion: MoveTo (gEgo x?) 244 self
					setCycle: 0
				)
				(gLongSong number: 45 loop: 1 priority: 15 play:)
			)
			(2
				(gEgo hide:)
				(= local2
					(if (== global132 2)
						(proc255_0 10 19 91)
					else
						(proc255_0 10 20 91)
					)
				)
				(= seconds 5)
			)
			(3
				(proc0_12)
				(proc0_17 901 0 0 1)
			)
		)
	)
)

(instance grabScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(if (== gNorth 9) (gEgo x: 4))
				(if (== global132 5)
					(gEgo setStep: 2 setPri: 5)
				else
					(gEgo setPri: 14 setStep: 3)
				)
				(gEgo init: setCycle: Fwd)
				(if (< global148 4)
					(gEgo
						setMotion: MoveTo (if (== gNorth 9) 400 else -50) (gEgo y?)
					)
					(User prevDir: (if (== gNorth 9) 3 else 7))
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 100])
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look/grabber,control') (proc255_0 10 21))
			(
				(or
					(Said 'lower/claw[<grabber]')
					(Said 'use,press,press/claw,button')
				)
				(proc255_0 10 22)
			)
			((Said '/chair[<grabber,device]') (proc255_0 10 23))
			((Said 'disembark[/grabber,device,!*]') (proc255_0 10 24))
		)
	)
)

(instance pile1 of Act
	(properties
		view 750
	)
	
	(method (init)
		(super init:)
		(self
			setCel: 1
			setLoop: 0
			ignoreActors: 1
			illegalBits: 0
			posn: -32 145
			setPri: 6
			setStep: 3 1
		)
	)
)

(instance fallPile of Prop
	(properties
		view 750
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 2
			cel: 0
			ignoreActors: 1
			posn: 187 159
			setPri: 10
			setScript: newPileScript
		)
	)
)

(instance shredder of Prop
	(properties
		view 20
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			posn: 204 169
			setPri: 9
			setCycle: Fwd
		)
	)
)
