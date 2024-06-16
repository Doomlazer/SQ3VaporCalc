;;; Sierra Script 1.0 - (do not remove this comment)
(script# 31)
(include sci.sh)
(use Main)
(use Sound)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm031 0
)

(local
	local0
	local1
	[local2 2]
)
(instance rm031 of Rm
	(properties)
	
	(method (init &tmp [temp0 50])
		(self picture: 31)
		(= global17 0)
		(proc0_2)
		(= global159 1)
		(TheMenuBar hide:)
		(SL disable:)
		(Load rsVIEW 54)
		(if (not global151)
			(Load rsVIEW 58)
			(Load rsVIEW 60)
			(Load rsPIC 30)
			(Load rsSOUND 10)
			(Load rsSOUND 80)
		)
		(Load rsSOUND 9)
		(Load rsSOUND 79)
		(super init:)
		(ship init:)
		(self setScript: shipScript)
	)
)

(instance shipScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 5))
			(1
				(ship setMotion: MoveTo 164 110 self)
				(gLongSong number: 9 play:)
			)
			(2
				(ship
					cycleSpeed: (if (!= global209 6) 2 else 0)
					setCycle: End self
				)
			)
			(3
				(if (== global209 6)
					(ship cel: 0 setLoop: 1 setCycle: End self)
					(hit number: 79 play:)
				else
					(= cycles 2)
				)
				(gLongSong stop:)
			)
			(4 (= seconds 2) (hit stop:))
			(5
				(if (not global151)
					(gLongSong number: 10 play:)
					(= seconds 3)
				else
					(gLongSong fade:)
					(global2 newRoom: 14)
				)
			)
			(6
				(termShip setLoop: 0 init:)
				(global2 setScript: termScript)
			)
		)
	)
)

(instance termScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not global151)
					(termShip setCycle: End self)
				else
					(self changeState: 4)
				)
			)
			(1
				(if (< (termShip loop?) 6)
					(termShip cel: 0 setLoop: (+ (termShip loop?) 1))
					(self changeState: (- state 1))
				else
					(= global151 1)
					(termShip setCycle: Fwd)
					(= seconds 3)
				)
			)
			(2
				(global2 setScript: rm30Script)
			)
			(3
				(termShip setCycle: 0 setMotion: MoveTo 158 142 self)
			)
			(4 (= cycles 3))
			(5
				(termShip
					setMotion: MoveTo (termShip x?) (- (termShip y?) 20) self
				)
			)
			(6
				(termShip cel: 0 setLoop: 7 setCycle: End self)
			)
			(7
				(termShip cel: 0 setLoop: 8 setCycle: End self)
				(hit number: 80 play:)
				(gLongSong stop:)
			)
			(8 (= seconds 2))
			(9 (global2 newRoom: 14))
		)
	)
)

(instance rm30Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship dispose:)
				(termShip dispose:)
				(global2 drawPic: 30)
				(mouth init:)
				(starBar init: stopUpd:)
				(= cycles 2)
			)
			(1 (= seconds 3))
			(2
				(= local0
					(Display
						{...DEMRIFNOC YTITNEDI}
						dsFONT
						601
						dsWIDTH
						115
						dsCOLOR
						10
						dsALIGN
						1
						dsCOORD
						116
						35
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(3
				(= local1
					(Display
						{OCLIW REGOR\n:218UO ESAC}
						dsFONT
						601
						dsWIDTH
						115
						dsCOLOR
						10
						dsCOORD
						116
						45
						dsALIGN
						1
						dsSAVEPIXELS
					)
				)
				(= seconds 4)
			)
			(4
				(Display 31 0 108 local0)
				(Display 31 0 108 local1)
				(= cycles 5)
			)
			(5
				(= local0
					(Display
						{ROF DETNAW OCLIW\nDUARF ENIHCAM GNIDNEV\n\n:FFITNIALP\n.OC YTLEVON DIOZAPPIG_}
						dsFONT
						601
						dsWIDTH
						115
						dsCOLOR
						10
						dsALIGN
						1
						dsCOORD
						116
						35
						dsSAVEPIXELS
					)
				)
				(= seconds 5)
			)
			(6
				(Display 31 0 108 local0)
				(= cycles 5)
			)
			(7
				(= local0
					(Display
						{:TNEMEGDUJ}
						dsFONT
						601
						dsWIDTH
						115
						dsCOLOR
						10
						dsCOORD
						122
						38
						dsALIGN
						1
						dsSAVEPIXELS
					)
				)
				(= seconds 2)
			)
			(8 (= cycles 10))
			(9
				(termText init: setCycle: End self)
			)
			(10
				(termText setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(11
				(mouth setMotion: MoveTo 162 190 self)
			)
			(12 (= seconds 2))
			(13
				(mouth stopUpd:)
				(starBar
					setMotion: MoveTo (- (starBar x?) 40) (starBar y?) self
				)
			)
			(14
				(mouth dispose:)
				(starBar dispose:)
				(termText dispose:)
				(Display 31 0 108 local0)
				(global2 drawPic: 31)
				(termShip setLoop: 6 setCel: 0 init:)
				(= cycles 2)
			)
			(15
				(global2 setScript: termScript)
			)
		)
	)
)

(instance ship of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 54
			setLoop: 0
			setCel: 0
			posn: 164 179
			setStep: 1 1
			ignoreActors: 1
			illegalBits: 0
			setCycle: 0
		)
	)
)

(instance termShip of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 60
			cel: 0
			posn: 158 152
			setStep: 1 1
			ignoreActors: 1
			illegalBits: 0
			setCycle: 0
		)
	)
)

(instance mouth of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 58
			setLoop: 0
			posn: 162 174
			setStep: 1 4
			ignoreActors: 1
			illegalBits: 0
			stopUpd:
		)
	)
)

(instance starBar of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 58
			setLoop: 3
			posn: 193 74
			setPri: 4
			setStep: 2 1
			ignoreActors: 1
			setCycle: 0
		)
	)
)

(instance termText of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 58
			setLoop: 1
			setCel: 0
			posn: 179 58
			setPri: 10
			ignoreActors: 1
		)
	)
)

(instance hit of Sound
	(properties
		priority 5
	)
)
