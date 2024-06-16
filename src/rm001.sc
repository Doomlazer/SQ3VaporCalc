;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1)
(include sci.sh)
(use Main)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm001 0
)

(local
	local0
	local1
	local2
)
(instance rm001 of Rm
	(properties
		picture 1
	)
	
	(method (init &tmp [temp0 50])
		(proc0_2)
		(Load rsSOUND 72)
		(Load rsSOUND 73)
		(Load rsSOUND 87)
		(Load rsPIC 1)
		(Load rsPIC 150)
		(Load rsPIC 151)
		(Load rsPIC 152)
		(Load rsPIC 153)
		(Load rsPIC 154)
		(Load rsPIC 926)
		(Load rsVIEW 1)
		(Load rsVIEW 2)
		(Load rsVIEW 3)
		(Load rsVIEW 4)
		(Load rsVIEW 5)
		(Load rsVIEW 601)
		(Load rsVIEW 926)
		(super init:)
		(self setScript: openingScript)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if (pEvent type?)
			(Display 1 0 108 local0)
			(Display 1 0 108 local1)
			(gLongSong stop:)
			(global2 newRoom: 2)
		)
	)
)

(instance openingScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (== (gLongSong prevSignal?) -1) (== local2 1))
			(= local2 0)
			(openingScript cue:)
		)
		(if
		(and (== local2 2) (== (beamSound prevSignal?) -1))
			(= local2 0)
			(global2 newRoom: 155)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 5))
			(1
				(global2 overlay: 926 3)
				(= cycles 2)
			)
			(2
				(drip1 init:)
				(drip2 init:)
				(drip3 init:)
				(drip4 init:)
				(= seconds 3)
			)
			(3
				(= local0
					(Display
						{\04 1989 Sierra On-Line, Inc.}
						dsWIDTH
						250
						dsCOORD
						35
						180
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(= seconds 7)
			)
			(4
				(drip1 dispose:)
				(drip2 dispose:)
				(drip3 dispose:)
				(drip4 dispose:)
				(Display 1 0 108 local0)
				(global2 drawPic: 150 5)
				(= cycles 2)
			)
			(5
				(Mark init: setCycle: End setMotion: MoveTo 52 37 self)
			)
			(6
				(Mark stopUpd:)
				(Scott init: setCycle: End setMotion: MoveTo 268 37 self)
			)
			(7 (= cycles 2))
			(8
				(Scott stopUpd:)
				(= local0
					(Display
						{Created and Written by}
						dsWIDTH
						250
						dsCOORD
						30
						90
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display
						{Mark Crowe and Scott Murphy}
						dsWIDTH
						250
						dsCOORD
						30
						105
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						15
						dsSAVEPIXELS
					)
				)
				(= seconds 7)
			)
			(9
				(Scott dispose:)
				(Mark dispose:)
				(Display 1 0 108 local0)
				(Display 1 0 108 local1)
				(proc0_10)
				(= local1
					(Display
						{Programmed by\n\n\nGraphics by\n\nGame Development System by\n\n\nMusic by\n\nSound Effects & Music Editing by}
						dsWIDTH
						250
						dsCOORD
						30
						25
						dsALIGN
						0
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(proc0_10)
				(= local0
					(Display
						{\nScott Murphy, Doug Oldfield,\nKen Koch, Chris Smith\n\nMark Crowe\n\nJeff Stephenson, Bob Heitman,\nPablo Ghenis, Stuart Goldstein\n\nBob Siebenberg\n\nMark Seibert}
						dsWIDTH
						250
						dsCOORD
						80
						25
						dsALIGN
						0
						dsFONT
						300
						dsCOLOR
						15
						dsSAVEPIXELS
					)
				)
				(= seconds 12)
			)
			(10
				(Display 1 0 108 local0)
				(Display 1 0 108 local1)
				(proc0_10)
				(= local0
					(Display
						{It has been an indeterminate amount\nof time since Roger Wilco rocketed\naway from Vohaul's burning space\nfortress. Time stands still for our\nhero in suspended animation.}
						dsWIDTH
						250
						dsCOORD
						35
						65
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(= seconds 12)
			)
			(11
				(Display 1 0 108 local0)
				(= cycles 2)
			)
			(12
				(= local0
					(Display
						{Its engines long spent, the small\nescape pod drifts aimlessly through\nunfamiliar star fields, its course\naltered many times by small asteroids\nand space debris. Inside, Roger lies\nundisturbed in his sleep chamber....\n...but not for long.}
						dsWIDTH
						250
						dsCOORD
						35
						65
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(= seconds 13)
			)
			(13 (= local2 1))
			(14
				(Display 1 0 108 local0)
				(proc0_10)
				(gLongSong number: 72 play:)
				(pod init: setMotion: MoveTo 129 97 self)
			)
			(15
				(gLongSong number: 73 loop: -1 play:)
				(global2 overlay: 151 6)
				(podOutline init: setCycle: Fwd)
				(pod setMotion: MoveTo -54 97 self)
			)
			(16
				(podOutline dispose:)
				(pod dispose:)
				(= global17 8)
				(global2 drawPic: 150)
				(= cycles 3)
			)
			(17
				(global2 overlay: 152)
				(= cycles 7)
			)
			(18
				(podImage init: setCycle: End self)
			)
			(19 (= cycles 2))
			(20
				(podImage stopUpd:)
				(scanner init: setCycle: Fwd)
				(= seconds 3)
			)
			(21
				(lifeForm init: setCycle: Fwd)
				(= seconds 5)
			)
			(22
				(scanner dispose:)
				(alienWord init:)
				(= seconds 3)
			)
			(23
				(alienText init: setMotion: MoveTo 221 127 self)
			)
			(24
				(alienText posn: 221 127 stopUpd:)
				(alienWord setCel: 1 stopUpd:)
				(= cycles 15)
			)
			(25
				(gCast eachElementDo: #dispose)
				(= global17 0)
				(global2 drawPic: 153)
				(pod3 init: setMotion: MoveTo 87 156 self)
				(light init:)
				(hand init:)
			)
			(26
				(gCast eachElementDo: #dispose)
				(global2 drawPic: 154 3)
				(pod2 init: setMotion: MoveTo 184 169 self)
				(hatch init:)
			)
			(27
				(beamSound play:)
				(pod2 setStep: 1 1 setMotion: MoveTo 137 169 self)
				(= cycles 2)
			)
			(28
				(beam init: stopUpd:)
				(gLongSong stop:)
			)
			(29 (= cycles 20))
			(30
				(pod2 setMotion: MoveTo 137 80 self)
			)
			(31 (= cycles 2))
			(32
				(beam dispose:)
				(self setScript: closeHatchScript self)
			)
			(33
				(pod2 dispose:)
				(= seconds 2)
			)
			(34
				(Display
					1
					1
					dsWIDTH
					250
					dsALIGN
					1
					dsCOORD
					35
					120
					dsFONT
					300
					dsCOLOR
					14
				)
				(= seconds 12)
			)
			(35 (= local2 2))
		)
	)
)

(instance openHatchScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(hatch stopUpd:)
				(= seconds 5)
			)
			(1 (hatch setCycle: End self))
			(2 (hatch stopUpd:))
			(3 (self dispose:))
		)
	)
)

(instance closeHatchScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(hatch setPri: 8 setCycle: Beg self)
			)
			(1
				(hatch stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance handScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(hand
					setLoop: 1
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 121 191 self
				)
			)
			(2 (hand setCycle: End self))
			(3
				(light setCycle: Fwd)
				(= seconds 2)
			)
			(4
				(hand setCel: 0 setMotion: MoveTo 169 191 self)
			)
			(5 (= cycles 15))
			(6 (hand setCycle: End self))
			(7
				(hand setCel: 0 setMotion: MoveTo 121 223)
			)
		)
	)
)

(instance podOutline of Prop
	(properties
		view 1
		cel 1
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setLoop: 1
			setCel: 1
			setPri: 5
			posn: 127 97
		)
	)
)

(instance lifeForm of Prop
	(properties
		view 2
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 2 setPri: 5 posn: 152 86)
	)
)

(instance scanner of Prop
	(properties
		view 2
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 3 setPri: 5 posn: 105 111)
	)
)

(instance podImage of Prop
	(properties
		view 2
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setLoop: 1
			setPri: 5
			posn: 111 97
			cycleSpeed: 1
		)
	)
)

(instance hatch of Act
	(properties
		view 3
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setLoop: 0
			setCel: 0
			setPri: 5
			posn: 108 102
			setScript: openHatchScript
		)
	)
)

(instance hand of Act
	(properties
		view 5
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			posn: 121 223
			setLoop: 1
			setCel: 0
			setPri: 6
			setStep: 8 8
			setCycle: 0
			setScript: handScript
		)
	)
)

(instance Scott of Act
	(properties
		view 601
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			ignoreActors: 1
			posn: 160 100
			setPri: 4
			setStep: 12 12
		)
	)
)

(instance Mark of Act
	(properties
		view 601
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 1
			ignoreActors: 1
			posn: 160 100
			setPri: 4
			setStep: 12 12
		)
	)
)

(instance drip1 of Prop
	(properties
		view 926
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 0
			posn: 141 112
			setPri: 15
			setCycle: Fwd
		)
	)
)

(instance drip2 of Prop
	(properties
		view 926
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 9
			posn: 163 152
			setPri: 15
			setCycle: Fwd
		)
	)
)

(instance drip3 of Prop
	(properties
		view 926
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 2
			posn: 216 148
			setPri: 15
			setCycle: Fwd
		)
	)
)

(instance drip4 of Prop
	(properties
		view 926
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 4
			posn: 270 143
			setPri: 15
			setCycle: Fwd
		)
	)
)

(instance drip5 of Prop
	(properties
		view 926
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 6
			posn: 34 145
			setPri: 15
			setCycle: Fwd
		)
	)
)

(instance pod3 of Act
	(properties
		view 5
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setLoop: 2
			setPri: 4
			posn: 191 52
			setStep: 5 2
		)
	)
)

(instance light of Prop
	(properties
		view 5
		priority 6
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)
)

(instance beam of View
	(properties
		view 4
	)
	
	(method (init)
		(super init:)
		(self posn: 110 189 setPri: 6)
	)
)

(instance pod2 of Act
	(properties
		view 3
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 1
			ignoreActors: 1
			illegalBits: 0
			posn: 320 169
			setPri: 7
			setStep: 2 1
		)
	)
)

(instance pod of Act
	(properties
		view 1
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setLoop: 0
			setCel: 0
			setPri: 4
			posn: 363 97
			setStep: 2
		)
	)
)

(instance alienWord of Prop
	(properties
		view 2
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setLoop: 4
			setPri: 6
			posn: 226 144
			setCycle: Fwd
		)
	)
)

(instance alienText of Act
	(properties
		view 2
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setLoop: 0
			setPri: 4
			posn: 221 205
			setStep: -1 6
		)
	)
)

(instance beamSound of Sound
	(properties
		number 87
		priority 5
	)
)
