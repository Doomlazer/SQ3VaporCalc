;;; Sierra Script 1.0 - (do not remove this comment)
(script# 117)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm117 0
)

(local
	[local0 2]
	local2
	local3
)
(procedure (localproc_062a param1)
	(= local3
		(Display
			param1
			dsWIDTH
			250
			dsCOORD
			35
			120
			dsALIGN
			1
			dsFONT
			300
			dsCOLOR
			10
			dsSAVEPIXELS
		)
	)
	(proc0_10)
)

(procedure (localproc_0651)
	(Display 117 1 108 local3)
	(proc0_10)
)

(instance rm117 of Rm
	(properties
		picture 83
	)
	
	(method (init)
		(= global17 0)
		(proc0_2)
		(= global159 1)
		(TheMenuBar state: 1 draw:)
		(SL enable:)
		(Load rsVIEW 54)
		(Load rsVIEW 139)
		(Load rsSOUND 81)
		(super init:)
		(ship init:)
		(self setScript: shipScript)
	)
)

(instance shipScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2
					(Display
						117
						0
						dsWIDTH
						250
						dsCOORD
						35
						25
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(gLongSong number: 81 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(ship setMotion: MoveTo 164 110 self)
			)
			(2
				(ship cycleSpeed: 0 setCycle: End self)
			)
			(3
				(ship cel: 0 setLoop: 1 setCycle: End self)
			)
			(4 (= seconds 2))
			(5
				(Display 117 1 108 local2)
				(global2 setScript: endScript)
			)
		)
	)
)

(instance endScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(end init: setCycle: End self)
			)
			(1 (= seconds 5))
			(2
				(end setCel: 255 setMotion: MoveTo 154 45 self)
			)
			(3
				(end stopUpd:)
				(= seconds 3)
			)
			(4
				(= local2
					(Display
						{Thanks To The Following For Their\nCooperation In The Making Of This Game:}
						dsWIDTH
						250
						dsCOORD
						35
						85
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(5
				(localproc_062a {Pestulon Department of Forestry})
				(= seconds 6)
			)
			(6
				(localproc_0651)
				(localproc_062a {Monolith Synthetic Industries, Inc.})
				(= seconds 6)
			)
			(7
				(localproc_0651)
				(localproc_062a {Fester's World-O-Wonders})
				(= seconds 6)
			)
			(8
				(localproc_0651)
				(localproc_062a {Gippazoid Novelties})
				(= seconds 6)
			)
			(9
				(localproc_0651)
				(localproc_062a {Phleebhut Sand Advisory Council})
				(= seconds 6)
			)
			(10
				(localproc_0651)
				(localproc_062a {Arnoid Droidworks})
				(= seconds 6)
			)
			(11
				(localproc_0651)
				(localproc_062a {Caffeinate 90})
				(= seconds 6)
			)
			(12
				(localproc_0651)
				(localproc_062a {OrboSnack Food Inhalers})
				(= seconds 6)
			)
			(13
				(localproc_0651)
				(localproc_062a {Friends of the Talking Bear Society})
				(= seconds 6)
			)
			(14
				(localproc_0651)
				(localproc_062a
					{Mark Seibert, Bob Siebenberg\n& Stuart Goldstein\nFor Their Outstanding Sound Work}
				)
				(= seconds 6)
			)
			(15
				(localproc_0651)
				(localproc_062a
					{Doug Oldfield, Ken Koch & Chris Smith\nFor A Great Programming Effort}
				)
				(= seconds 6)
			)
			(16
				(Display 117 1 108 local2)
				(Display 117 1 108 local3)
				(proc0_10)
				(= local2
					(Display
						{The Little People, Nobodies, Scum\nWould Also Like To Thank\n}
						dsWIDTH
						250
						dsCOORD
						35
						85
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display
						{Robert E. "Bobbit" Heitman\nFor His Generous, Yet Verbose, Contribution of Advice, Help & Emergency Code Service}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(= seconds 6)
			)
			(17
				(Display 117 1 108 local2)
				(proc0_10)
				(Display 117 1 108 local3)
				(proc0_10)
				(= local2
					(Display
						{Very Special Thanks to}
						dsWIDTH
						250
						dsCOORD
						35
						95
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(proc0_10)
				(= local3
					(Display
						{The Two Babes From Andromeda\n(Our Wives)\nFor Putting Up With Us These Last 12 Months}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(= seconds 8)
			)
			(18
				(Display 117 1 108 local3)
				(proc0_10)
				(= local3
					(Display
						{You!\n(For Shelling Out Your Hard Earned Bucks To Buy This Game)}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						1
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(= seconds 6)
			)
			(19
				(Display 117 1 108 local2)
				(Display 117 1 108 local3)
				(proc0_10)
				(self changeState: 4)
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

(instance end of Act
	(properties
		view 139
	)
	
	(method (init)
		(super init:)
		(self posn: 154 103 cel: 0 cycleSpeed: 1)
	)
)
