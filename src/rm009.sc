;;; Sierra Script 1.0 - (do not remove this comment)
(script# 9)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Timer)
(use Sound)
(use Jump)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm009 0
)

(local
	bucketCel
	newAct
	gEgoX
	local3
	local4
	local5
)
(instance rm009 of Rm
	(properties
		picture 9
		style $0000
		horizon 10
		east 10
		west 12
	)
	
	(method (init &tmp [temp0 50])
		(self setLocales: 703)
		(if (== gNorth 4) (proc0_2) else (proc0_3))
		(Load rsVIEW 13)
		(Load rsVIEW 750)
		(Load rsVIEW 17)
		(Load rsSOUND 75)
		(Load rsSOUND 76)
		(Load rsSOUND 74)
		(Load rsSOUND 45)
		(cond 
			((== global132 4) (Load rsVIEW 22) (Load rsVIEW 258) (Load rsVIEW 260))
			((== global132 5) (Load rsVIEW 23) (Load rsVIEW 259) (Load rsVIEW 261))
			((== global132 1) (Load rsSOUND 56))
			(else (Load rsSCRIPT 991) (= local4 991))
		)
		(if (or (== global132 4) (== global132 5))
			(Load rsSOUND 52)
			(Load rsSOUND 53)
		else
			(Load rsSOUND 41)
		)
		(gLongSong priority: 1)
		(gEgo setStep: -1 1)
		(super init:)
		(self setScript: rmScript)
	)
	
	(method (dispose)
		(if (== global132 3) (DisposeScript 991))
		(super dispose:)
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
							((Said '/conveyer,belt,bucket,hoist,elevator')
								(if (== global124 0)
									(proc255_0 9 0)
								else
									(proc255_0 9 1)
								)
							)
							((Said '/iron,scrap,debris,heap,garbage')
								(if (== global124 0)
									(proc255_0 9 2)
								else
									(proc255_0 9 3)
								)
							)
							((Said '[<at,around,in][/area,!*]')
								(cond 
									((== global132 3) (proc255_0 9 4))
									((== global132 2) (proc255_0 9 5))
									(else (proc255_0 9 6))
								)
							)
						)
					)
					((Said 'jump/conveyer,belt,bucket') (proc255_0 9 7))
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
		(if (== global132 2) (gEgo cycleSpeed: 0))
		(if (and (!= global132 4) (!= global132 5))
			(gLongSong stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (> global124 0) (== global132 1))
					(elevSound play:)
					(pile init:)
					(bucket init:)
				)
				(if (> global132 1)
					(proc0_3)
					(cond 
						((== global132 3) (gEgo init: setScript: railWalkScript))
						((or (== global132 5) (== global132 4)) (gEgo setScript: grabScript))
					)
				)
			)
		)
	)
)

(instance pileScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(pile setMotion: MoveTo 337 147)
			)
			(1
				(pile
					x: (if (< gNorth 9) 271 else 309)
					y: 147
					setCel: bucketCel
				)
				(self changeState: 0)
			)
		)
	)
)

(instance bScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bucket setCycle: 0 setMotion: MoveTo 240 114 self)
			)
			(1
				(= bucketCel (bucket cel?))
				(if (== (bucket cel?) 2)
					(gEgo setCycle: 0 setScript: dumpScript init:)
				)
				(bucket
					setLoop: 1
					cel: 0
					posn: 256 114
					setMotion: 0
					setCycle: End self
				)
			)
			(2
				(bucket setLoop: 0 setCel: (Random 0 1) posn: 240 212)
				(self changeState: 0)
				(pileScript cue:)
			)
		)
	)
)

(instance dumpScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 17
					setLoop: 0
					cel: 0
					setPri: 6
					posn: 255 95
					illegalBits: 0
					ignoreActors: 1
					setStep: 4 8
					setMotion: MoveTo 289 159 self
					cycleSpeed: 1
					setCycle: 0
					setCycle: End
				)
				(= global132 2)
			)
			(1
				(thump play:)
				(gEgo
					view: 750
					setLoop: 1
					cel: 0
					posn: 291 147
					cycleSpeed: 2
					setCycle: End
					setStep: 2 1
					setMotion: MoveTo 400 147
				)
			)
		)
	)
)

(instance railWalkScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (not global100) (!= (gEgo onControl: 1) 16384))
			(proc0_2)
			(proc0_10)
			(self changeState: 1)
			(= global100 1)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo
					view: 17
					setLoop: (gEgo loop?)
					cel: 0
					setPri: (if (< (gEgo y?) 125) 8 else 9)
					illegalBits: 0
					setCycle: End self
				)
			)
			(2
				(gLongSong number: 45 loop: 1 priority: 15 play:)
				(gEgo
					setStep: 1 15
					setMotion: JumpTo (gEgo x?) 244 self
					setCycle: 0
				)
			)
			(3
				(gEgo hide:)
				(= local5 (proc255_0 9 8 91))
				(Timer set: self 5)
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
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 5)
					(gEgo
						view: (if (== gGGGGNorth 3) 261 else 23)
						setPri: 4
						setStep: 2
						y: 88
					)
				else
					(gEgo
						view: (if (== gGGGGNorth 3) 260 else 22)
						setPri: 14
						setStep: 3
						y: 116
					)
				)
				(gEgo init: setCycle: Fwd)
				(if (< global148 4)
					(gEgo
						setMotion: MoveTo (if (== gNorth 10) -40 else 400) (gEgo y?)
					)
					(User prevDir: (if (== gNorth 10) 7 else 3))
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
			((Said 'look/grabber') (proc255_0 9 9))
			(
				(or
					(Said 'lower/claw[<grabber]')
					(Said 'use,press,press/claw,button')
				)
				(cond 
					((gEgo mover?) (proc255_0 9 10))
					((and (!= global148 2) (!= global148 3))
						(proc0_2)
						(= global159 1)
						(gEgo setMotion: 0)
						(clunk number: 74 loop: 1 play:)
						(gEgo setScript: clawScript)
					)
					(else (proc255_0 9 11))
				)
			)
			((Said '/chair[<grabber,device]') (proc255_0 9 12))
			((Said 'disembark[/grabber,device,!*]') (proc255_0 9 13))
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
				(= local3
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
						y: (if (> global148 3) 191 else local3)
						init:
					)
				else
					(= gEgoX (gEgo x?))
					(= local3
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
					setPri: (if (== global132 5) 4 else (gEgo priority?))
					ignoreActors: 1
					illegalBits: 0
					setCycle: Fwd
					setMotion: MoveTo gEgoX (if (> global148 3) local3 else 191) self
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
					(clunk number: (if (== global148 4) 75 else 76) play:)
					(proc0_3)
					(= global159 0)
					(if (== global148 4)
						(= global148 0)
					else
						(= global148 1)
					)
					(clawScript dispose:)
				else
					(if (> gEgoX 141) (= gGGGNorth 1) else (= gGGGNorth 0))
					(= gGEgoX (gEgo x?))
					(= gGEgoY (gEgo y?))
					(if (== global132 4)
						(global2 newRoom: 4)
					else
						(global2 newRoom: 5)
					)
				)
			)
		)
	)
)

(instance pile of Act
	(properties
		view 750
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: (Random 0 1)
			setPri: 6
			ignoreActors: 1
			illegalBits: 0
			posn: 309 147
			setStep: 2
			setScript: pileScript
		)
	)
)

(instance bucket of Act
	(properties
		view 13
		illegalBits $0000
		moveSpeed 1
	)
	
	(method (init)
		(super init:)
		(bucket
			posn: 240 (if (< gNorth 9) 224 else 204)
			setPri: 7
			setStep: -1 2
			setLoop: 0
			setCel: (if (< global132 2) 2 else (Random 0 1))
			cycleSpeed: 4
			setScript: bScript
			ignoreActors: 1
		)
	)
)

(instance elevSound of Sound
	(properties
		number 41
		loop -1
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 2
	)
)

(instance clunk of Sound
	(properties
		number 75
		priority 5
	)
)
