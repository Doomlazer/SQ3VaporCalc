;;; Sierra Script 1.0 - (do not remove this comment)
(script# 421)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Chase)
(use Avoid)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room421 0
)

(local
	local0
	local1
	thePulley1
	local3
	local4
	newView
	newView_2
	newSound
	local8
	local9
)
(instance deathSound of Sound
	(properties)
)

(instance elevator of Act
	(properties)
)

(instance elevTop of Prop
	(properties)
)

(instance elevBottom of Prop
	(properties)
)

(instance cable1 of Prop
	(properties)
)

(instance cable2 of View
	(properties)
)

(instance gear of Prop
	(properties)
)

(instance pulley1 of Act
	(properties)
)

(instance pulley2 of Act
	(properties)
)

(instance Room421 of Rm
	(properties
		picture 421
		vanishingY -400
	)
	
	(method (init)
		(super init:)
		(= local8 500)
		(= local4 1)
		(Load rsVIEW 94)
		(Load rsVIEW 777)
		(Load rsVIEW 119)
		(Load rsVIEW 108)
		(Load rsVIEW 106)
		(Load rsVIEW 120)
		(Load rsSOUND 91)
		(Load rsSOUND 92)
		(gEgo init:)
		(if (== global117 421)
			(= local0 5)
			((= gNewAct (View new:))
				view: 120
				setLoop: 4
				setCel: 6
				setPri: 0
				posn: 160 127
				init:
				stopUpd:
			)
		)
		(if (proc0_13 16 421)
			((= gNewView_2 (View new:))
				view: 120
				loop: 5
				cel: 0
				posn: 157 124
				setPri: 1
				init:
				stopUpd:
			)
		)
		(gear
			view: 120
			loop: 0
			posn: 158 65
			ignoreActors:
			setCycle: Fwd
			setScript: gearActions
			init:
		)
		(gLongSong number: 85 loop: -1 play:)
		(pulley1
			view: 120
			setLoop: 1
			setCel: 1
			ignoreActors:
			illegalBits: 0
			ignoreHorizon:
			posn: 77 -23
			setPri: 0
			init:
			stopUpd:
		)
		(pulley2
			view: 120
			setLoop: 1
			illegalBits: 0
			ignoreHorizon:
			ignoreActors:
			setCel: 1
			posn: 108 0
			setPri: 15
			init:
			stopUpd:
		)
		(gEgo
			view: 83
			loop: 2
			cel: 2
			posn: 56 202
			setPri: 8
			setLoop: 2
			setCel: 2
			ignoreActors:
			illegalBits: 0
			init:
		)
		(cable1
			view: 83
			loop: 3
			cel: 9
			ignoreActors:
			posn: 56 83
			setPri: 7
			cycleSpeed: 5
			init:
			stopUpd:
		)
		(cable2
			view: 83
			loop: 3
			cel: 0
			ignoreActors:
			posn: 56 71
			setPri: 7
			init:
			stopUpd:
		)
		(global2 setScript: raise)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
		(and (& (gEgo onControl: 0) $0004) (not global155))
			(= global104 7)
			(if (and (gCast contains: gNewAct) (< local0 5))
				(gNewAct setMotion: 0)
			)
			(pulley1 setScript: smash)
		)
		(if
			(and
				(& (gEgo onControl: 0) $1000)
				(== global104 2)
				(== local1 0)
				(<= (bringOnFester state?) 0)
			)
			(pulley1 setScript: fall)
		)
		(cond 
			((== global104 1) (gEgo setPri: 8))
			(
			(and (== global104 2) (gEgo inRect: 0 135 91 163)) (gEgo setPri: 14))
			(
				(and
					(== global104 2)
					(gEgo inRect: 266 140 303 147)
					(not global155)
				)
				(= global104 3)
				(gEgo
					setPri: 10
					ignoreControl: 16384
					observeControl: 8192
				)
			)
			(
				(and
					(== global104 3)
					(gEgo inRect: 268 148 308 154)
					(not global155)
				)
				(= global104 2)
				(gEgo
					setPri: -1
					observeControl: 16384
					ignoreControl: 8192
				)
			)
			(
				(and
					(== global104 3)
					(not global155)
					(gEgo inRect: 239 52 270 57)
				)
				(= global104 4)
				(gEgo
					setPri: -1
					observeControl: 16384
					ignoreControl: 8192
				)
				(if
					(and
						(or (== global110 1) (== global110 2))
						(== local0 0)
					)
					(self setScript: termComesUp)
				)
			)
			(
				(and
					(== global104 4)
					(gEgo inRect: 239 57 272 64)
					(not global155)
				)
				(= global104 3)
				(gEgo
					setPri: 10
					ignoreControl: 16384
					observeControl: 8192
				)
			)
			((== global104 3) (gEgo setPri: 10))
			(
				(and
					(== global104 4)
					(gEgo inRect: 0 62 252 76)
					(not global155)
				)
				(gEgo setPri: 14)
			)
			(
				(and
					(== global104 4)
					(& (gEgo onControl: 0) $0200)
					(not global155)
				)
				(gEgo setPri: 9)
			)
			((not global155) (gEgo setPri: -1))
		)
		(cond 
			(
			(and (== local0 4) (gNewAct inRect: 0 62 237 76)) (gNewAct setPri: 14))
			(
			(and (== local0 2) (gNewAct inRect: 0 136 91 163)) (gNewAct setPri: 14))
			(
				(and
					(!= global110 3)
					(== local0 4)
					(gNewAct setPri: -1)
				)
			)
			((== local0 3) (gNewAct setPri: 10))
			(
			(and (== local0 4) (& (gNewAct onControl: 0) $0200)) (gNewAct setPri: 9))
			((== local0 4) (gNewAct setPri: -1))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(if (== (pEvent type?) evSAID)
			(cond 
				((Said 'look,converse/blatz')
					(if (== (global2 script?) bringOnFester)
						(cond 
							((== local1 1) (proc255_0 421 0))
							((== local1 2) (proc255_0 421 1))
							(else (proc255_0 421 2))
						)
					else
						(proc255_0 421 2)
					)
				)
				((Said 'look>')
					(cond 
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(proc255_0 421 3)
						)
						((Said '/stair') (proc255_0 421 4))
						((Said '/pedestal') (proc255_0 421 5))
						((Said '<down') (proc255_0 421 6))
						((or (Said '<up') (Said '/ceiling')) (proc255_0 421 7))
						((Said '/android')
							(cond 
								((== local0 0) (proc255_0 421 8))
								((== local0 1) (proc255_0 421 9))
								(
								(and (>= local0 2) (!= local0 5) (!= local0 6)) (proc255_0 421 10))
								((== local0 5)
									(if
										(and
											(== global104 2)
											(<= (gEgo distanceTo: gNewAct) 30)
										)
										(proc255_0
											(Format
												@global402
												421
												11
												(if (proc0_13 16 421)
													{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
												else
													{}
												)
											)
										)
									else
										(proc255_0 421 12)
									)
								)
							)
						)
						((and (Said '/debris') (== local0 5))
							(if
								(and
									(== global104 2)
									(<= (gEgo distanceTo: gNewAct) 30)
								)
								(proc255_0
									(Format
										@global402
										421
										11
										(if (proc0_13 16 421)
											{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
										else
											{}
										)
									)
								)
							else
								(proc255_0 421 12)
							)
						)
						((Said '/engine,device,equipment') (proc255_0 421 13))
						((Said '/cog') (proc255_0 421 14))
						((Said '/rope,scout,pulley,jar') (proc255_0 421 15))
						((Said '/banister') (proc255_0 421 16))
						((Said '/overhang') (proc255_0 421 17))
						((Said '/pit') (proc255_0 421 18))
						((Said '/bolt') (proc255_0 421 19))
						((Said '/elevator')
							(if (or (== local1 2) (== local1 1))
								(proc255_0 421 20)
							else
								(proc255_0 421 21)
							)
						)
						((Said '/button,control')
							(if
							(and (gEgo inRect: 0 37 73 133) (== global104 2))
								(proc255_0 421 22)
							else
								(proc255_0 421 23)
							)
						)
					)
				)
				(
				(and (Said 'explore/android,debris,body') (== local0 5))
					(if
						(and
							(== global104 2)
							(<= (gEgo distanceTo: gNewAct) 30)
						)
						(proc255_0
							(Format
								@global402
								421
								11
								(if (proc0_13 16 421)
									{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
								else
									{}
								)
							)
						)
					else
						(proc255_0 421 12)
					)
				)
				(
				(or (Said 'press<up') (Said 'press/button<up'))
					(if (gEgo inRect: 39 123 62 133)
						(proc255_0 421 24)
					else
						(proc0_5)
					)
				)
				(
					(or
						(Said 'press/button')
						(Said 'press<down')
						(Said 'use/elevator')
					)
					(if
					(and (gEgo inRect: 39 123 63 133) (== local1 2))
						(proc255_0 421 25)
						(global2 setScript: lowerEgoElevator)
					else
						(proc0_5)
					)
				)
				((Said 'converse/android')
					(if (gCast contains: gNewAct)
						(proc255_0 421 26)
					else
						(proc255_0 421 27)
					)
				)
				((Said 'board,drag,hold/scout,rope,jar') (proc255_0 421 28))
				(
				(Said 'swing,get,press,use/scout,pulley,rope,jar')
					(switch local3
						(0 (gEgo setScript: doPulley))
						(2 (proc255_0 421 29))
						(else  (proc255_0 421 30))
					)
				)
				((Said 'get/scout,banister,rope') (proc255_0 421 31))
				((Said 'get/belt')
					(cond 
						((gEgo has: 16) (proc255_0 421 32))
						((not (proc0_13 16 421)) (proc255_0 421 33))
						((> (gEgo distanceTo: gNewView_2) 12) (proc0_5))
						(else
							(proc255_0 421 34)
							(gNewView_2 dispose:)
							(gGame changeScore: 35)
							(if (> (bringOnFester seconds?) 5)
								(bringOnFester seconds: 5)
							)
							(gEgo get: 16)
						)
					)
				)
				((Said 'get/android')
					(if (== local0 5)
						(proc255_0 421 35)
					else
						(proc255_0 421 36)
					)
				)
				((Said 'get<in/elevator') (proc255_0 421 37))
				((Said 'attack/android') (proc255_0 421 38))
				((Said 'use/orat,stick') (proc255_0 421 39))
				((Said 'jump') (proc255_0 421 40))
				((Said 'turn<off/engine') (proc255_0 421 41))
				((Said 'climb') (proc255_0 421 42))
				((Said '/scout,jar,rope,cog,device,engine') (proc255_0 421 43))
			)
		)
		(return
			(if
				(and
					(== (pEvent type?) evKEYBOARD)
					(== (pEvent message?) KEY_RETURN)
					(== (global2 script?) bringOnFester)
					(<= 2 (bringOnFester state?))
					(<= (bringOnFester state?) 4)
				)
				(proc0_12)
				(bringOnFester seconds: 0)
				(bringOnFester cue:)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gSounds eachElementDo: #fade)
		(super newRoom: newRoomNumber)
	)
)

(instance raise of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global104 1)
				(gEgo setMotion: MoveTo 56 83 self)
				(cable1 setCycle: Beg)
			)
			(1
				(proc0_3)
				(elevTop
					view: 83
					setLoop: 2
					cel: 1
					posn: 56 85
					setPri: 10
					ignoreActors:
					init:
					stopUpd:
				)
				(elevBottom
					view: 83
					setLoop: 2
					cel: 0
					posn: 56 85
					setPri: 8
					ignoreActors:
					init:
					stopUpd:
				)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					illegalBits: -32768
					observeControl: 16384
					posn: 56 129
					setPri: -1
				)
				(= global104 2)
				(= local1 2)
			)
		)
	)
)

(instance termComesUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= local1 1)
				(gEgo observeControl: 4096)
				(elevator
					view: 83
					setLoop: 2
					setCel: 4
					posn: 56 (elevTop y?)
					illegalBits: 0
					ignoreActors:
					setPri: 8
					setMotion: MoveTo 56 202 self
					init:
				)
				(cable1
					view: 83
					ignoreActors:
					posn: 56 83
					loop: 3
					cel: 255
					cycleSpeed: 5
					setCycle: End
				)
				(elevTop view: 777 forceUpd:)
				(elevBottom view: 777 forceUpd:)
			)
			(1
				(elevator setCel: 3 setMotion: MoveTo 56 83 self)
				(cable1 cel: 9 setCycle: Beg)
			)
			(2
				(elevator dispose:)
				(elevTop view: 83 setLoop: 2 setCel: 1)
				(elevBottom view: 83 setLoop: 2 setCel: 0)
				(cable1 view: 777 stopUpd:)
				(= gNewAct (Act new:))
				(gNewAct
					view: 119
					posn: 64 128
					loop: 0
					setCycle: Walk
					setAvoider: Avoid
					setMotion: MoveTo 89 128 self
					init:
				)
			)
			(3
				(if (!= global104 7)
					((= newView (View new:))
						view: 108
						setLoop: 6
						setCel: 0
						posn: 114 92
						ignoreActors:
						setPri: 15
						init:
					)
					(= seconds 3)
				)
			)
			(4
				(if (!= global104 7)
					(newView dispose:)
					(gNewAct setScript: termChase)
					(= local1 1)
					(gEgo observeControl: 4096)
					(elevator
						view: 83
						setLoop: 2
						setCel: 4
						posn: 56 (elevTop y?)
						illegalBits: 0
						ignoreActors:
						setPri: 8
						setMotion: MoveTo 56 202 self
						init:
					)
					(cable1
						view: 83
						ignoreActors:
						posn: 56 83
						loop: 3
						cel: 255
						cycleSpeed: 5
						setCycle: End
					)
					(elevTop view: 777 stopUpd:)
					(elevBottom view: 777 stopUpd:)
				)
			)
			(5
				(= local1 0)
				(cable1 stopUpd:)
				(gEgo ignoreControl: 4096)
				(gNewAct observeControl: 4096)
			)
		)
	)
)

(instance termChase of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(cond 
			((== local0 2)
				(cond 
					(
						(and
							(or (== global104 4) (== global104 3))
							(!= state 1)
						)
						(self changeState: 1)
					)
					(
					(and (== global104 2) (!= state 7) (< state 8)) (self changeState: 7))
				)
			)
			((== local0 3)
				(cond 
					(
					(and (== global104 4) (!= state 2) (< state 8)) (self changeState: 2))
					(
					(and (== global104 3) (< state 8) (!= state 7)) (self changeState: 7))
					(
					(and (== global104 2) (< state 8) (!= state 5)) (self changeState: 5))
				)
			)
			((== local0 4)
				(cond 
					(
					(and (== global104 4) (< state 8) (!= state 7)) (self changeState: 7))
					(
					(and (== global104 3) (< state 8) (!= state 4)) (self changeState: 4))
					((and (== global104 2) (!= state 4)) (self changeState: 4))
				)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 2)
				(gNewAct observeControl: 4096)
			)
			(1
				(gNewAct setMotion: MoveTo 286 156 self)
			)
			(2
				(gNewAct
					setMotion: MoveTo 248 47 self
					setPri: 10
					ignoreControl: 16384 2048
					observeControl: 8192
				)
				(= local0 3)
			)
			(3
				(= local0 4)
				(gNewAct
					setMotion: Chase gEgo 10 self
					observeControl: 4 16384
					ignoreControl: 8192
					setPri: -1
				)
				(= state 7)
			)
			(4
				(gNewAct
					ignoreControl: 2048
					setMotion: MoveTo 252 51 self
				)
			)
			(5
				(= local0 3)
				(gNewAct
					observeControl: 2048
					setMotion: MoveTo 290 156 self
					ignoreControl: 16384
					setPri: 10
					observeControl: 8192
				)
			)
			(6
				(= local0 2)
				(gNewAct
					setMotion: Chase gEgo 10 self
					observeControl: 16384
					setPri: -1
					ignoreControl: 8192
				)
				(= state 7)
			)
			(7
				(gNewAct setMotion: Chase gEgo 10 self)
			)
			(8
				(proc0_2)
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
			(9
				(gEgo setLoop: 5 setCycle: Fwd)
				(gNewAct
					view: 106
					setLoop: 6
					illegalBits: 0
					setPri: (gEgo priority?)
					setCycle: Fwd
					show:
				)
				(= seconds 2)
			)
			(10
				(gNewAct
					view: 106
					setLoop: 7
					setPri: (gEgo priority?)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(11
				(gEgo hide:)
				((= newSound (Sound new:))
					number: 97
					loop: -1
					priority: 99
					play:
				)
				(gNewAct setLoop: 8 setCycle: Fwd)
				(= seconds 6)
			)
			(12
				(newSound stop:)
				(gNewAct setLoop: 8 setCel: 0)
				(proc0_17 901 0 14 16)
			)
		)
	)
)

(instance doPulley of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
			(and
				(== local3 1)
				(== local0 4)
				(gCast contains: gNewAct)
			)
			(cond 
				(
					(and
						(== (thePulley1 heading?) 90)
						(< (Abs (- (gNewAct x?) (thePulley1 x?))) 12)
						(or
							(and
								(== thePulley1 pulley1)
								(> (gNewAct y?) 41)
								(< (gNewAct y?) 49)
							)
							(and
								(== thePulley1 pulley2)
								(> (gNewAct y?) 60)
								(< (gNewAct y?) 72)
							)
						)
					)
					(if
					(or (< (gNewAct x?) 113) (> (gNewAct x?) 192))
						(= local3 3)
						(proc255_0 421 44)
					else
						(self changeState: 5)
					)
				)
				(
					(and
						(== (thePulley1 heading?) 270)
						(< (Abs (- (thePulley1 x?) (gNewAct x?))) 12)
						(or
							(and
								(== thePulley1 pulley1)
								(> (gNewAct y?) 41)
								(< (gNewAct y?) 49)
							)
							(and
								(== thePulley1 pulley2)
								(> (gNewAct y?) 60)
								(< (gNewAct y?) 72)
							)
						)
					)
					(if
					(or (< (gNewAct x?) 113) (> (gNewAct x?) 192))
						(proc255_0 421 44)
						(= local3 3)
					else
						(self changeState: 5)
					)
				)
			)
		)
		(if
			(and
				(== local3 1)
				(or
					(and
						(< (thePulley1 x?) 39)
						(== (thePulley1 heading?) 270)
					)
					(and
						(> (thePulley1 x?) 230)
						(== (thePulley1 heading?) 90)
					)
				)
			)
			(thePulley1 cel: 1 setMotion: 0 stopUpd:)
			(= state 4)
			(proc0_10)
			(proc255_0 421 45)
			(= local3 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					(
						(and
							(gCast contains: gNewAct)
							(< (gEgo distanceTo: gNewAct) 25)
						)
						(proc255_0 421 46)
						(gEgo setScript: 0)
					)
					(
						(and
							(== global104 4)
							(< (gEgo y?) 49)
							(< (Abs (- (gEgo x?) (pulley1 x?))) 10)
						)
						(= thePulley1 pulley1)
						(self changeState: 1)
					)
					(
						(and
							(== global104 4)
							(> (gEgo y?) 61)
							(< (Abs (- (gEgo x?) (pulley2 x?))) 10)
						)
						(= thePulley1 pulley2)
						(self changeState: 1)
					)
					(else (proc0_5) (gEgo setScript: 0))
				)
			)
			(1
				(proc255_0 421 47 67 -1 (- (gEgo y?) 20))
				(switch (gEgo loop?)
					(0
						(thePulley1
							startUpd:
							cel: 0
							xStep: 8
							setMotion: MoveTo (+ (thePulley1 x?) 50) (thePulley1 y?) self
						)
					)
					(1
						(thePulley1
							startUpd:
							cel: 2
							xStep: 6
							setMotion: MoveTo (- (thePulley1 x?) 50) (thePulley1 y?) self
						)
					)
					(else 
						(if (gCast contains: gNewAct)
							(if (< (gEgo x?) (gNewAct x?))
								(thePulley1
									startUpd:
									cel: 0
									xStep: 8
									setMotion: MoveTo (+ (thePulley1 x?) 50) (thePulley1 y?) self
								)
							else
								(thePulley1
									startUpd:
									cel: 2
									xStep: 8
									setMotion: MoveTo (- (thePulley1 x?) 50) (thePulley1 y?) self
								)
							)
						else
							(thePulley1
								startUpd:
								cel: 0
								xStep: 8
								setMotion: MoveTo (+ (thePulley1 x?) 50) (thePulley1 y?) self
							)
						)
					)
				)
				(= local3 1)
			)
			(2
				(if (== (thePulley1 heading?) 90)
					(thePulley1
						cel: 1
						setMotion: MoveTo (+ (thePulley1 x?) 50) (thePulley1 y?) self
					)
				else
					(thePulley1
						cel: 1
						setMotion: MoveTo (- (thePulley1 x?) 50) (thePulley1 y?) self
					)
				)
			)
			(3
				(if (== (thePulley1 heading?) 90)
					(thePulley1
						cel: 2
						setMotion: MoveTo (+ (thePulley1 x?) 50) (thePulley1 y?) self
					)
				else
					(thePulley1
						cel: 0
						setMotion: MoveTo (- (thePulley1 x?) 50) (thePulley1 y?) self
					)
				)
			)
			(4
				(= local3 0)
				(thePulley1 cel: 1 setMotion: 0 stopUpd:)
			)
			(5
				(= local3 2)
				(if (== (thePulley1 heading?) 90)
					(thePulley1
						cel: 1
						setMotion: MoveTo (- (thePulley1 x?) 15) (thePulley1 y?)
					)
				else
					(thePulley1
						cel: 1
						setMotion: MoveTo (+ (thePulley1 x?) 15) (thePulley1 y?)
					)
				)
				(= local0 6)
				(proc0_2)
				(= newView_2 (View new:))
				(newView_2
					view: 120
					loop: 1
					cel: 3
					posn: (gNewAct x?) (- (gNewAct y?) 30)
					setPri: 15
					init:
				)
				(gNewAct
					view: 120
					setLoop: (- 3 (& (gNewAct loop?) $0001))
					cel: 255
					illegalBits: 0
					setCycle: End
					setStep: 6 4
					setMotion: MoveTo 160 55 self
				)
				(= seconds 2)
			)
			(6 (newView_2 dispose:))
			(7
				(deathSound number: 91 priority: 20 play:)
				(gNewAct
					setLoop: 4
					setCycle: Fwd
					setPri: -1
					setMotion: MoveTo 160 127 self
				)
			)
			(8
				(proc0_3)
				(= local0 5)
				(gNewAct ignoreActors: 0 setCel: 6 setPri: 0 stopUpd:)
				((= gNewView_2 (View new:))
					view: 120
					loop: 5
					cel: 0
					posn: 157 124
					setPri: 1
					init:
				)
				(gGame changeScore: 35)
				(proc0_14 16 421)
				(gEgo setScript: 0)
				(global2 setScript: bringOnFester)
				(= global117 421)
				(= global110 3)
			)
		)
	)
)

(instance smash of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(deathSound number: 92 priority: 21 play:)
				(gEgo
					view: 120
					setLoop: 6
					illegalBits: 0
					ignoreActors:
					posn: 156 63
					setPri: 7
					setCycle: Fwd
				)
				(= seconds 7)
				(if
					(and
						(gCast contains: gNewAct)
						(< local0 5)
						(gCast contains: gNewAct)
						(== (gNewAct script?) termChase)
					)
					(global2 setScript: 0)
					(gNewAct setMotion: 0)
				)
			)
			(1 (proc0_17 901 0 3 99))
		)
	)
)

(instance bringOnFester of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
		(and (== local1 2) (& (gEgo onControl: 0) $1000))
			(self changeState: 10)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 60))
			(1
				(gEgo observeControl: 4096)
				(= local1 1)
				(elevator
					setCel: 5
					setPri: 9
					setMotion: MoveTo 56 83 self
				)
				(cable1 cel: 9 setCycle: Beg)
			)
			(2
				(elevator setPri: 9 setMotion: MoveTo 56 85 self)
			)
			(3
				(proc0_2)
				(pulley1 startUpd:)
				(pulley2 setPri: 14 startUpd:)
				(gear setCycle: Fwd startUpd:)
				(gLongSong loop: -1 play:)
				(== local8 -200)
				(proc0_10)
				(proc255_0 421 48 67 66 53 91 80 {Fester})
				(= seconds 8)
			)
			(4
				(proc0_12)
				(proc0_10)
				(proc255_0 421 49 67 66 29 91 80 {Fester})
				(= seconds 12)
			)
			(5
				(proc0_12)
				(proc255_0 421 50 67 66 65 91 80 {Fester})
				(gEgo ignoreControl: 4096)
				(= local1 2)
				(= seconds 4)
			)
			(6
				(proc0_12)
				(proc0_3)
				(gEgo ignoreControl: 4096)
				(= seconds 15)
			)
			(7
				(proc0_12)
				(proc255_0 421 51 67 66 64 25 5 80 {Fester})
				(-- state)
				(= seconds 20)
			)
			(10
				(proc0_2)
				(= seconds 0)
				(pulley1 stopUpd:)
				(pulley2 stopUpd:)
				(gEgo view: 777 stopUpd:)
				(elevTop view: 777 stopUpd:)
				(elevBottom view: 777 stopUpd:)
				(elevator
					setLoop: 2
					setCel: 6
					setMotion: MoveTo (elevator x?) 220 self
				)
				(cable1 setCycle: End)
			)
			(11 (global2 newRoom: 42))
		)
	)
)

(instance fall of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(bringOnFester seconds: 0)
				(global2 setScript: 0)
				(elevator
					view: 94
					setLoop: 0
					cel: 255
					yStep: 9
					ignoreActors:
					illegalBits: 0
					posn: 56 (gEgo y?)
					cycleSpeed: 3
					setCycle: End
					init:
				)
				(deathSound number: 45 priority: 12 loop: 1 play:)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setPri: 8
					yStep: 15
					posn: 64 127
					setCycle: 0
					setMotion: MoveTo 64 300 self
				)
				(= global104 7)
				(if (and (gCast contains: gNewAct) (< local0 5))
					(gNewAct setScript: 0 setMotion: 0)
				)
			)
			(1
				(elevator hide:)
				(= seconds 6)
			)
			(2 (proc0_17 901 0 0 1))
		)
	)
)

(instance lowerEgoElevator of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global104 1)
				(gEgo setMotion: MoveTo 56 129 self)
			)
			(1
				(gEgo view: 777 stopUpd:)
				(elevTop view: 777 stopUpd:)
				(elevBottom view: 777 stopUpd:)
				(elevator
					view: 83
					setLoop: 2
					setCel: 2
					setPri: 8
					illegalBits: 0
					ignoreActors:
					posn: (elevBottom x?) (elevBottom y?)
					setMotion: MoveTo (elevBottom x?) 220 self
					init:
				)
				(cable1 setCycle: End)
			)
			(2 (global2 newRoom: 420))
		)
	)
)

(instance gearActions of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber)
			(return (!= gGNorth gNewRoomNumber))
		)
		(return
			(if (not global124)
				(cond 
					((== local4 0)
						(if
							(or
								(== global104 7)
								(== local3 1)
								(== local0 6)
								(>= local8 200)
							)
							(= local8 0)
							(gear setCycle: Fwd startUpd:)
							(gLongSong loop: -1 play:)
							(= local4 1)
						else
							(++ local8)
						)
					)
					(
						(and
							(!= global104 7)
							(or
								(>= local8 40)
								(and (gCast contains: elevator) (< (elevator y?) 189))
							)
						)
						(= local4 0)
						(gear setCycle: 0 stopUpd:)
						(gLongSong stop:)
						(= local8 0)
					)
					(else (++ local8))
				)
			else
				0
			)
		)
	)
)
