;;; Sierra Script 1.0 - (do not remove this comment)
(script# 15)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Rev)
(use Extra)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm015 0
)

(local
	local0
)
(instance rm015 of Rm
	(properties
		style $0000
	)
	
	(method (init &tmp [temp0 50])
		(if ((gInv at: 3) ownedBy: 15)
			(self picture: 15)
		else
			(self picture: 157)
		)
		(self setLocales: 700)
		(proc0_2)
		(Load rsVIEW 19)
		(Load rsVIEW 29)
		(Load rsVIEW 32)
		(Load rsVIEW 6)
		(Load rsVIEW 33)
		(Load rsVIEW 34)
		(Load rsVIEW 35)
		(if
		(and (not (proc0_13 2 8)) (not (gEgo has: 2)))
			(Load rsVIEW 15)
		else
			(Load rsVIEW 288)
		)
		(if (!= gNorth 3) (Load rsSOUND 56))
		(if (and global133 (== gNorth 3)) (Load rsSOUND 11))
		(Load rsSOUND 12)
		(= global132 0)
		(super init:)
		(self setScript: rmScript)
	)
	
	(method (doit)
		(if (proc0_13 3)
			(if
				(and
					(== (gEgo view?) 0)
					(or
						(== (gEgo onControl: 0) 4)
						(== (gEgo onControl: 0) 5)
					)
				)
				(gEgo view: 32)
			)
			(if
			(and (== (gEgo view?) 32) (== (gEgo onControl: 0) 1))
				(gEgo view: 0)
			)
		)
		(if
			(and
				(proc0_13 2 8)
				(not global155)
				(gEgo inRect: 165 150 175 186)
			)
			(proc0_2)
			(self setScript: mugScript)
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(!= (pEvent type?) evSAID)
				global100
				(pEvent claimed?)
			)
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '[<around,at,in][/area,!*]')
						(if (proc0_13 3)
							(proc255_0 15 0)
						else
							(proc255_0 15 1)
						)
					)
					((Said '/lamp')
						(if (proc0_13 3)
							(proc255_0 15 2)
						else
							(proc255_0 15 3)
						)
					)
					((Said '/cable') (proc255_0 15 4))
					((and local0 (Said '/hook')) (proc255_0 15 5))
					((and local0 (Said '/mice,animal,animal')) (proc255_0 15 6))
					((or (Said '/hal<cable') (Said '/cable<hal'))
						(if (gEgo inRect: 0 125 38 155)
							(if (proc0_13 3)
								(proc255_0 15 7)
							else
								(proc255_0 15 8)
							)
						else
							(proc255_0 15 9)
						)
					)
					((Said '/cavity')
						(cond 
							((gEgo inRect: 0 125 38 155)
								(proc255_0
									(Format
										@global402
										15
										10
										(cond 
											((and (proc0_13 3) (proc0_13 0) (proc0_13 1))
												{a tiny reactor which seems to be providing power for the lights, a formerly lustrous gem, and an unconnected wire}
											)
											((and (proc0_13 3) (proc0_13 0))
												{a tiny reactor which seems to be providing power for the lights and a formerly lustrous gem}
											)
											((and (proc0_13 3) (proc0_13 1))
												{a tiny reactor which seems to be providing power for the lights and an unconnected wire}
											)
											((and (proc0_13 0) (proc0_13 1)) {a formerly lustrous gem, and an unconnected wire})
											((proc0_13 3)
												{a tiny reactor which seems to be providing power for the lights}
											)
											((proc0_13 1) {an unconnected wire})
											((proc0_13 0) {a formerly lustrous gem})
											(else {nothing but crusty wire ends})
										)
									)
								)
							)
							((gEgo inRect: 248 69 265 77) (proc255_0 15 11))
							(else (proc255_0 15 12))
						)
					)
					(
					(or (Said '<up[/ceiling,!*]') (Said '[<up]/ceiling')) (proc255_0 15 13))
					((Said '/left,partition<w') (proc255_0 15 14))
					((Said 'climb/support,cover') (proc255_0 15 15))
					((Said '/system,door[<garbage]') (proc255_0 15 16))
					((Said 'look/ladder')
						(if (proc0_13 2)
							(proc255_0 15 17)
						else
							(pEvent claimed: 0)
						)
					)
					(
					(or (Said '<down[/deck,!*]') (Said '[<down]/deck')) (proc255_0 15 18))
					((Said '/partition[<pod,north,e]') (proc255_0 15 19))
					((Said '/heap,artifact,chunk') (proc255_0 15 20))
					((Said '/support') (proc255_0 15 21))
					((Said '/cover') (proc255_0 15 22))
				)
			)
			(
			(or (Said 'climb[/ladder]') (Said 'go<up/ladder'))
				(if
				(and (gEgo inRect: 248 69 265 77) (proc0_13 2))
					(gEgo setScript: ladderScript)
				else
					(proc255_0 15 23)
				)
			)
			((Said 'get>')
				(cond 
					((Said '/all')
						(if (gEgo inRect: 0 125 38 155)
							(if (proc0_13 0) (gEgo get: 0) (gGame changeScore: 5))
							(if (proc0_13 1) (gEgo get: 1) (gGame changeScore: 5))
							(if (proc0_13 3)
								(gEgo get: 3)
								(proc255_0 15 24)
								(reactorScript init:)
								(gGame changeScore: 15)
							else
								(proc255_0 15 24)
							)
						else
							(proc0_5)
						)
					)
					((Said '/ladder')
						(if
							(and
								(gEgo inRect: 248 69 265 77)
								((gInv at: 2) ownedBy: 15)
							)
							(ladder dispose:)
							(gEgo get: 2)
							(gGame changeScore: 10)
							(proc255_0 15 25)
							(proc255_0 15 26)
						else
							(proc255_0 15 27)
						)
					)
					((or (Said '/hal<cable') (Said '/cable<hal'))
						(if (gEgo inRect: 0 125 38 155)
							(if (proc0_13 3)
								(proc255_0 15 7)
							else
								(proc255_0 15 28)
							)
						else
							(proc255_0 15 28)
						)
					)
					((Said '/artifact,support,cover') (proc255_0 15 29))
					((Said '/generator')
						(if (proc0_13 3)
							(if (gEgo inRect: 0 125 38 155)
								(gGame changeScore: 15)
								(proc255_0 15 30)
								(reactorScript init:)
							else
								(proc255_0 15 31)
							)
						else
							(proc255_0 15 32)
						)
					)
					((Said '/cable')
						(if (proc0_13 1)
							(if (gEgo inRect: 0 125 38 155)
								(proc255_0 15 24)
								(gEgo get: 1)
								(gGame changeScore: 5)
							else
								(proc0_5)
							)
						else
							(pEvent claimed: 0)
						)
					)
					((Said '/crystal')
						(if (proc0_13 0)
							(if (gEgo inRect: 0 125 38 155)
								(proc255_0 15 24)
								(gEgo get: 0)
								(gGame changeScore: 5)
							else
								(proc0_5)
							)
						else
							(pEvent claimed: 0)
						)
					)
				)
			)
			(
				(Said
					'climb,crawl[<through,up,on]/partition,cavity,system'
				)
				(proc255_0 15 33)
			)
			((Said 'use,afix,(jar<up)/generator')
				(if (or (gEgo has: 3) (proc0_13 3))
					(proc255_0 15 34)
				else
					(pEvent claimed: 0)
				)
			)
			(
				(Said
					'erect,stand,drop,place,use/ladder[/cavity[<by,in]]'
				)
				(if (gEgo inRect: 170 66 292 97)
					(if (gEgo has: 2)
						(gEgo setScript: putLadderScript)
					else
						(proc255_0 15 35)
					)
				else
					(proc255_0 15 36)
				)
			)
			((Said 'open/system,door') (proc255_0 15 37))
		)
	)
	
	(method (newRoom newRoomNumber)
		(DisposeScript 988)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(doors init:)
				(if ((gInv at: 2) ownedBy: 15) (ladder init: stopUpd:))
				(if (== gNorth 3)
					(gEgo setScript: ladderScript)
					(doors stopUpd:)
				else
					(= cycles 3)
				)
			)
			(1 (doors setCycle: End self))
			(2
				(gEgo
					view: 35
					posn: 70 120
					setPri: 8
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					init:
					setMotion: 0
					setCycle: End self
				)
			)
			(3
				(doors stopUpd:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
				(thump play:)
			)
			(4
				(gEgo hide:)
				(doors setCycle: Beg self)
			)
			(5
				(doors addToPic:)
				(proc255_0 15 38)
				(= seconds 2)
			)
			(6
				(proc0_3)
				(gEgo
					view: (if (proc0_13 3) 32 else 6)
					illegalBits: -32768
					posn: 80 132
					setLoop: -1
					setPri: -1
					loop: 2
					setStep: 3 2
					show:
					cycleSpeed: 0
					setCycle: Walk
				)
				(if (and (proc0_13 3) (not (proc0_13 2 8)))
					(rat1 setScript: ratsScript)
				)
				(if (and global133 (== gNorth 3))
					(gLongSong number: 11 loop: -1 play:)
				)
				(= global100 0)
			)
		)
	)
)

(instance reactorScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ladder setLoop: 1 forceUpd:)
				(gEgo get: 3 view: 6)
				(global2 drawPic: 157)
				(doors setLoop: 1 init: addToPic:)
				(rat1 setLoop: 4 init: addToPic:)
				(rat2 setLoop: 4 init: addToPic:)
				(rat3 setLoop: 4 init: addToPic:)
				(eye1 setLoop: 5)
				(eye2 setLoop: 6)
				(eye3 setLoop: 7)
			)
		)
	)
)

(instance mugScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 15 39)
				(proc255_0 15 40)
				(gEgo view: 288 setLoop: 0 setMotion: MoveTo 170 145 self)
			)
			(1
				(gEgo setLoop: 1 setCycle: Fwd)
				(mugRat1
					init:
					setCycle: Walk
					setMotion: MoveTo 165 145 self
				)
				(mugRat2 init: setCycle: Walk setMotion: MoveTo 175 145)
			)
			(2
				(cloud init:)
				(rumble play:)
				(gEgo hide:)
				(mugRat1 hide:)
				(mugRat2 hide:)
				(= seconds 6)
			)
			(3
				(gEgo
					setLoop: 2
					posn: (- (gEgo x?) 20) (- (gEgo y?) 7)
					show:
					stopUpd:
				)
				(mugRat1
					setLoop: 1
					x: (- (mugRat1 x?) 50)
					show:
					setMotion: MoveTo 20 155 self
				)
				(mugRat2
					setLoop: 0
					x: (+ (mugRat2 x?) 50)
					show:
					setMotion: MoveTo 320 155
				)
				(cloud dispose:)
				(rumble stop:)
			)
			(4
				(proc255_0 15 41)
				(proc0_17 901 0 2 3)
			)
		)
	)
)

(instance ladderScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 19
					setLoop: (if (proc0_13 3) 0 else 1)
					setPri: 4
					illegalBits: 0
					ignoreActors: 1
				)
				(if (gEgo inRect: 248 69 265 77)
					(gEgo posn: 258 73 setMotion: MoveTo 258 23 self)
				else
					(gEgo
						posn: 258 23
						init:
						setMotion: MoveTo 258 73 self
						setCycle: Rev
					)
				)
			)
			(1
				(if (gEgo inRect: 248 69 265 77)
					(gEgo
						setPri: -1
						setLoop: -1
						view: (if (not (proc0_13 3)) 6 else 0)
						setCycle: Walk
						illegalBits: -32768
						ignoreActors: 0
					)
					(User canControl: 1 canInput: 1)
					(= global100 0)
				else
					(global2 newRoom: 3)
				)
			)
		)
	)
)

(instance putLadderScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= global100 1)
				(gEgo setMotion: MoveTo 258 76 self)
			)
			(1
				(gEgo loop: 3)
				(ladder
					setLoop: (if (proc0_13 3) 0 else 1)
					init:
					stopUpd:
				)
				(proc0_14 2)
				(gGame changeScore: -10)
				(= global100 0)
				(User canControl: 1)
			)
		)
	)
)

(instance ratsScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ratTune play:)
				(= local0 1)
				(rat1 posn: -24 242 init: setMotion: MoveTo 24 194 self)
			)
			(1
				(eye1 init: startExtra:)
				(rat2 posn: 348 227 init: setMotion: MoveTo 297 176 self)
			)
			(2
				(rat2 addToPic:)
				(eye2 init: startExtra:)
				(rat3 init: posn: 303 2 setMotion: MoveTo 261 44 self)
			)
			(3
				(rat3 addToPic:)
				(eye3 init: startExtra:)
			)
		)
	)
)

(instance doors of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 33
			loop: (if (proc0_13 3) 0 else 1)
			cel: 0
			posn: 64 110
			setPri: 8
			cycleSpeed: 2
		)
	)
)

(instance ladder of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 29
			setLoop: (if (proc0_13 3) 0 else 1)
			setCel: 0
			posn: 256 70
		)
	)
)

(instance rat1 of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 34
			setLoop: (if (proc0_13 3) 0 else 4)
			setCel: 0
			setStep: 3 3
			illegalBits: 0
			setPri: 15
			setCycle: 0
		)
	)
)

(instance rat2 of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 34
			setLoop: (if (proc0_13 3) 0 else 4)
			setCel: 1
			setStep: 3 3
			illegalBits: 0
			setPri: 15
			setCycle: 0
		)
	)
)

(instance rat3 of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 34
			setLoop: (if (proc0_13 3) 0 else 4)
			setCel: 2
			setStep: 3 3
			illegalBits: 0
			ignoreHorizon:
			setPri: 15
			setCycle: 0
		)
	)
)

(instance eye1 of Extra
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 34
			loop: (if (proc0_13 3) 1 else 5)
			cel: 0
			posn: 18 171
			setPri: 15
			cycleSpeed: 2
			pauseCel: 0
			minPause: 20
			maxPause: 50
			minCycles: 2
			maxCycles: 4
			isExtra: 1
		)
	)
)

(instance eye2 of Extra
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 34
			loop: (if (proc0_13 3) 2 else 6)
			cel: 0
			posn: 285 153
			setPri: 15
			cycleSpeed: 2
			pauseCel: 0
			minPause: 20
			maxPause: 50
			minCycles: 2
			maxCycles: 4
			isExtra: 1
		)
	)
)

(instance eye3 of Extra
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 34
			loop: (if (proc0_13 3) 3 else 7)
			cel: 0
			posn: 249 30
			setPri: 15
			cycleSpeed: 2
			pauseCel: 0
			minPause: 50
			maxPause: 100
			minCycles: 2
			maxCycles: 4
			isExtra: 1
		)
	)
)

(instance mugRat1 of Act
	(properties
		view 15
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			ignoreActors: 1
			illegalBits: 0
			posn: 20 155
			setStep: 12 2
		)
	)
)

(instance mugRat2 of Act
	(properties
		view 15
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 1
			ignoreActors: 1
			illegalBits: 0
			posn: 320 155
			setStep: 12 2
		)
	)
)

(instance cloud of Prop
	(properties
		view 15
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 3
			ignoreActors: 1
			posn: (- (gEgo x?) 1) (- (gEgo y?) 1)
			setPri: (+ (gEgo priority?) 1)
			setCycle: Fwd
		)
	)
)

(instance ratTune of Sound
	(properties
		number 12
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 2
	)
)

(instance rumble of Sound
	(properties
		number 60
		priority 2
		loop -1
	)
)
