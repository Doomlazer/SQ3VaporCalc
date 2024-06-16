;;; Sierra Script 1.0 - (do not remove this comment)
(script# 12)
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
	rm012 0
)

(local
	newAct
	gEgoX
	local2
	local3
	local4
)
(instance rm012 of Rm
	(properties
		picture 12
		style $0000
		horizon 10
		east 9
	)
	
	(method (init &tmp [temp0 50])
		(self setLocales: 703)
		(User canInput: 1 canControl: 1)
		(if (== global132 4)
			(Load rsVIEW 22)
			(Load rsVIEW 258)
			(Load rsVIEW 260)
		)
		(if (== global132 5)
			(Load rsVIEW 23)
			(Load rsVIEW 259)
			(Load rsVIEW 261)
		)
		(if (== global132 3)
			(Load rsVIEW 17)
			(Load rsSOUND 45)
			(Load rsSCRIPT 991)
			(= local3 991)
		else
			(Load rsSOUND 74)
			(Load rsSOUND 75)
			(Load rsSOUND 76)
		)
		(if (or (== global132 4) (== global132 5))
			(Load rsSOUND 52)
			(Load rsSOUND 53)
		)
		(gEgo setStep: -1 1)
		(gLongSong priority: 0 loop: -1)
		(super init:)
		(self
			setScript: (if (== global132 3) railWalkScript else grabScript)
		)
	)
	
	(method (dispose)
		(if (== global132 3) (DisposeScript 991))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evMOUSEBUTTON
				(if (and (not global155) (== (User controls?) 1))
					(gEgo setMotion: MoveTo (pEvent x?) (gEgo y?))
					(pEvent claimed: 1)
				)
			)
			(evSAID
				(if (Said 'look>')
					(cond 
						((Said '/door,corridor,partition,pit[<w]') (proc255_0 12 0))
						((Said '[<at,around,in][/area,!*]')
							(if (== global132 3)
								(proc255_0 12 1)
							else
								(proc255_0 12 2)
							)
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
		(super newRoom: newRoomNumber)
	)
)

(instance railWalkScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (not global100) (!= (gEgo onControl: 1) 16384))
			(self changeState: 1)
			(User canControl: 0 canInput: 0)
			(= global100 1)
		)
		(if (< (gEgo x?) 4)
			(gEgo setMotion: 0)
			(global2 newRoom: 13)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init:)
				(if (== gNorth 13) (gEgo posn: 10 123))
			)
			(1
				(gEgo
					view: 17
					setLoop: (gEgo loop?)
					cel: 0
					setMotion: 0
					illegalBits: 0
					setPri: (if (< (gEgo y?) 125) 8 else 9)
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: 0 setMotion: JumpTo (gEgo x?) 244 self)
				(gLongSong number: 45 loop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= local4 (proc255_0 12 3 91))
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
		(if global155 (return))
		(cond 
			((and (< global148 2) (not (gEgo mover?)))
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
		(if (and (== global132 5) (< (gEgo x?) 95))
			(gEgo setMotion: 0)
			(global2 newRoom: 13)
		)
		(if (and (== global132 4) (< (gEgo x?) 4))
			(gEgo setMotion: 0)
			(global2 newRoom: 13)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((== global132 5)
						(gEgo
							view: (if (== gGGGGNorth 3) 261 else 23)
							setPri: -1
							setStep: 2
							y: 88
						)
					)
					((== global132 4)
						(gEgo
							view: (if (== gGGGGNorth 3) 260 else 22)
							setPri: 9
							setStep: 3
							y: 116
						)
					)
				)
				(gEgo init: setCycle: Fwd)
				(if (< global148 4)
					(gEgo
						setMotion: MoveTo (if (== gNorth 13) 400 else -40) (gEgo y?)
					)
				)
				(if (== gNorth 13)
					(User prevDir: 3)
					(if (== global132 5)
						(gEgo x: (if (== global132 5) 98 else 4))
					else
						(gEgo x: 4)
					)
				)
				(if (== gNorth 9) (User prevDir: 7))
				(if (> global148 3)
					(gEgo
						view: (if (== global132 4) 22 else 23)
						loop: 2
						posn: gGEgoX gGEgoY
					)
					(User canControl: 0)
					(gEgo setScript: clawScript)
				)
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
			((Said 'look/grabber') (proc255_0 12 4))
			(
				(or
					(Said 'lower/claw[<grabber]')
					(Said 'use,press,press/claw,button')
				)
				(cond 
					((gEgo mover?) (proc255_0 12 5))
					(
						(or
							(< (gEgo x?) 30)
							(and (== global132 5) (< (gEgo x?) 124))
						)
						(proc255_0 12 6)
					)
					((and (!= global148 2) (!= global148 3))
						(= global159 1)
						(proc0_2)
						(gEgo setMotion: 0)
						(clunk number: 74 loop: 1 play:)
						(gEgo setScript: clawScript)
					)
					(else (proc255_0 12 7))
				)
			)
			((Said '/chair[<grabber,device]') (proc255_0 12 8))
			((Said 'disembark[/grabber,device,!*]') (proc255_0 12 9))
		)
	)
)

(instance clawScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
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
					(if (> gEgoX 212) (= gGGGNorth 1) else (= gGGGNorth 0))
					(= gGEgoX (gEgo x?))
					(= gGEgoY (gEgo y?))
					(if (== global132 4)
						(global2 newRoom: 3)
					else
						(global2 newRoom: 2)
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
