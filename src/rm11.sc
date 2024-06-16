;;; Sierra Script 1.0 - (do not remove this comment)
(script# 11)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm11 0
)

(local
	newAct
	gEgoX
	local2
	local3
	local4
	local5
)
(instance rm11 of Rm
	(properties
		picture 11
		style $0000
		horizon 10
		west 10
	)
	
	(method (init &tmp [temp0 50])
		(self setLocales: 703)
		(proc0_3)
		(Load rsVIEW 25)
		(Load rsSOUND 75)
		(Load rsSOUND 76)
		(Load rsSOUND 74)
		(if (== global132 3)
			(Load rsVIEW 17)
			(Load rsSOUND 45)
			(Load rsSCRIPT 991)
			(= local4 991)
		else
			(Load rsVIEW 22)
			(Load rsVIEW 258)
			(Load rsVIEW 260)
			(Load rsVIEW 23)
			(Load rsVIEW 259)
			(Load rsVIEW 261)
			(Load rsSOUND 52)
			(Load rsSOUND 53)
		)
		(super init:)
		(if (== global132 3)
			(gEgo setScript: railWalkScript)
		else
			(gEgo setScript: grabScript)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
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
							((Said '[<at,around,in][/area,!*]')
								(if (== global132 3)
									(proc255_0 11 0)
								else
									(proc255_0 11 1)
								)
							)
							((Said '/device,artifact') (proc255_0 11 2))
						)
					)
					((Said 'climb,jump/device') (proc255_0 11 3))
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
		(super newRoom: newRoomNumber)
	)
)

(instance railWalkScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (not global100) (!= (gEgo onControl: 0) 16384))
			(self changeState: 1)
			(proc0_2)
			(= global100 1)
			(if (> (gEgo x?) 240) (= local3 1))
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (gEgo setPri: 9 init:))
			(1
				(gEgo
					view: 17
					setLoop: (gEgo loop?)
					cel: 0
					setPri: (if (and (not local3) (< (gEgo y?) 125)) 8 else 9)
					setMotion: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(2
				(gEgo
					setStep: 1 15
					setMotion: MoveTo (gEgo x?) 244 self
					setCycle: 0
				)
				(gLongSong number: 45 loop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= local5
					(if local3 (proc255_0 11 4 91) else (proc255_0 11 5 91))
				)
				(= seconds 5)
			)
			(4
				(proc0_12)
				(proc0_17 901 0 0 1)
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
			(if (and (== global132 4) (> (gEgo x?) 248))
				(= global100 1)
				(proc0_2)
				(self changeState: 1)
			)
			(if (and (== global132 5) (> (gEgo x?) 103))
				(= global100 1)
				(proc0_2)
				(self changeState: 4)
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
						setPri: -1
						setStep: 2
						y: 88
					)
				else
					(gEgo
						view: (if (== gGGGGNorth 3) 260 else 22)
						setPri: 9
						setStep: 3
						y: 116
					)
				)
				(gEgo init: setCycle: Fwd)
				(if (< global148 4)
					(gEgo setMotion: MoveTo 400 (gEgo y?))
					(User prevDir: 3)
				)
				(if (> global148 3)
					(gEgo
						view: (if (== global132 4) 22 else 23)
						loop: 2
						posn: gGEgoX gGEgoY
					)
					(proc0_2)
					(global2 setScript: clawScript)
				)
			)
			(1
				(User canControl: 0 canInput: 1)
				(proc0_2)
				(gEgo
					view: 25
					setLoop: (if (!= gGGGGNorth 3) 2 else 5)
					illegalBits: 0
					x: 251
					y: 114
					setPri: -1
					setStep: 1 2
					setMotion: MoveTo 251 108 self
				)
			)
			(2
				(gEgo
					setLoop: (if (!= gGGGGNorth 3) 0 else 3)
					setStep: 6 2
					setMotion: MoveTo 179 84 self
				)
			)
			(3
				(gEgo
					view: (if (== gGGGGNorth 3) 261 else 23)
					setLoop: -1
					loop: 1
					setStep: 2 1
					posn: 103 88
					illegalBits: -32768
					setMotion: MoveTo -50 88
				)
				(proc0_3)
				(User prevDir: 7)
				(= global100 0)
				(= global132 5)
			)
			(4
				(User canControl: 0 canInput: 1)
				(proc0_2)
				(gEgo
					view: 25
					setLoop: (if (!= gGGGGNorth 3) 1 else 4)
					setStep: 6 2
					posn: 179 84
					setMotion: MoveTo 251 108 self
				)
			)
			(5
				(gEgo
					setLoop: (if (!= gGGGGNorth 3) 2 else 5)
					setStep: 1 2
					setMotion: MoveTo 251 114 self
				)
			)
			(6
				(gEgo
					view: (if (== gGGGGNorth 3) 260 else 22)
					setLoop: -1
					loop: 0
					setPri: 9
					setStep: 3 1
					posn: 248 116
					setMotion: MoveTo -1 116
					illegalBits: -32768
				)
				(proc0_3)
				(User prevDir: 7)
				(= global132 4)
				(= global100 0)
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
		(cond 
			((Said 'look/grabber') (proc255_0 11 6))
			(
				(or
					(Said 'lower/claw[<grabber]')
					(Said 'use,press,press/claw,button')
				)
				(cond 
					((gEgo mover?) (proc255_0 11 7))
					((and (!= global148 2) (!= global148 3))
						(= global159 1)
						(proc0_2)
						(gEgo setMotion: 0)
						(clunk number: 74 loop: 1 play:)
						(gEgo setScript: clawScript)
					)
					(else (proc255_0 11 8))
				)
			)
			((Said '/chair[<grabber,device]') (proc255_0 11 9))
			((Said 'disembark[/grabber,device,!*]') (proc255_0 11 10))
		)
	)
)

(instance clawScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= gEgoX (gEgo x?))
				(= local2
					(if (== global132 4)
						(+ (gEgo y?) 42)
					else
						(+ (gEgo y?) 22)
					)
				)
				(self changeState: 1)
			)
			(1
				(gEgo view: (if (== global132 4) 22 else 23) loop: 2)
				(if (not (gCast contains: newAct))
					((= newAct (Act new:))
						name: {Claw}
						x: gEgoX
						y: (if (> global148 3) 191 else local2)
						init:
					)
				else
					(= gEgoX (gEgo x?))
					(= local2
						(if (== global132 4)
							(+ (gEgo y?) 42)
						else
							(+ (gEgo y?) 22)
						)
					)
				)
				(newAct
					view: (if (== global132 4) 258 else 259)
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setStep: 1 (if (== global132 4) 2 else 1)
					setPri: (gEgo priority?)
					ignoreActors: 1
					illegalBits: 0
					setCycle: Fwd
					setMotion: MoveTo gEgoX (if (> global148 3) local2 else 191) self
				)
			)
			(2
				(if (> global148 3)
					(gEgo
						view: (if (== gGGGGNorth 3)
							(+ (gEgo view?) 238)
						else
							(gEgo view?)
						)
						loop: 0
					)
					(newAct dispose:)
					(proc0_3)
					(= global159 0)
					(clunk number: (if (== global148 4) 75 else 76) play:)
					(if (== global148 4)
						(= global148 0)
					else
						(= global148 1)
					)
					(clawScript dispose:)
				else
					(if
						(or
							(and (== global132 4) (< gEgoX 152))
							(and (== global132 5) (< gEgoX 50))
						)
						(= gGGGNorth 0)
					else
						(= gGGGNorth 1)
					)
					(= gGEgoX (gEgo x?))
					(= gGEgoY (gEgo y?))
					(if (== global132 4)
						(global2 newRoom: 8)
					else
						(global2 newRoom: 7)
					)
				)
			)
		)
	)
)

(instance clunk of Sound
	(properties
		number 75
		priority 5
	)
)
