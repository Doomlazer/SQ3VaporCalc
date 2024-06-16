;;; Sierra Script 1.0 - (do not remove this comment)
(script# 90)
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
	rm90 0
)

(local
	local0
	theWHallDoor
	theWDoorScript
	local3
	local4
	local5
	local6
	local7
	theState
	local9
)
(instance rm90 of Rm
	(properties
		picture 90
		style $0000
	)
	
	(method (init)
		(SL enable:)
		(proc0_3)
		(Load rsVIEW 105)
		(Load rsVIEW 110)
		(Load rsVIEW 109)
		(Load rsVIEW 111)
		(Load rsSOUND 14)
		(Load rsSOUND 49)
		(Load rsSOUND 57)
		(Load rsSOUND 67)
		(Load rsSOUND 60)
		(Load rsSOUND 74)
		(super init:)
		(self setScript: rmScript)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(if (and (< (gEgo x?) 84) (== local3 90))
					(cond 
						(
							(Said
								'look[/area,partition,left,right,up,down,ceiling,deck]'
							)
							(proc255_0 90 0)
						)
						((Said 'look/door') (proc255_0 90 1))
						((Said 'look,explore/area,closet') (gEgo setScript: searchScript))
						(
						(Said 'get,wear,drop,change,switch,explore/attire')
							(if (gEgo has: 12)
								(proc255_0 90 2)
							else
								(proc255_0 90 3)
								(proc255_0 90 4)
								(= temp0 0)
								(while (<= temp0 16)
									(if (gEgo has: temp0) (gEgo put: temp0 -1))
									(++ temp0)
								)
								(gEgo view: 109 get: 12 get: 13)
								(gGame changeScore: 5)
							)
						)
						((Said 'disembark,disembark[/area,closet]') (proc255_0 90 5))
					)
				)
				(cond 
					((Said 'get/life[<a]')
						(if global200
							(gEgo view: 109 get: 11 12 13 15)
						else
							(pEvent claimed: 0)
						)
					)
					(
						(Said
							'look[/area,corridor,deck,dirt,ceiling,partition,up,down,left,right]'
						)
						(cond 
							((and (<= 114 (gEgo x?)) (<= (gEgo x?) 203))
								(if (or (== (gEgo loop?) 3) (== (gEgo loop?) 2))
									(if (== local0 {some})
										(= local0 {no})
									else
										(= local0 {some})
									)
									(proc255_4 90 6 local0)
								else
									(proc255_0 90 7)
								)
							)
							(
								(or
									(and (== (gEgo loop?) 1) (> (gEgo x?) 114))
									(and (== (gEgo loop?) 0) (< (gEgo x?) 203))
								)
								(proc255_0 90 8)
							)
							(else (proc255_0 90 9))
						)
					)
					((Said 'look/closet') (proc255_0 90 10))
					((Said 'look/door')
						(if
							(or
								(== theWHallDoor wHallDoor)
								(== theWHallDoor eHallDoor)
							)
							(if local4 (proc255_0 90 11) else (proc255_0 90 12))
						else
							(proc255_0 90 13)
						)
					)
					(
					(or (Said 'look/mrgarbage') (Said 'look/garbage<mr'))
						(if (gEgo has: 13)
							((gInv at: 13) showSelf:)
						else
							(pEvent claimed: 0)
						)
					)
					((Said 'remove/attire[<janitor]')
						(if (gEgo has: 12)
							(proc255_0 90 14)
						else
							(pEvent claimed: 0)
						)
					)
					(
						(or
							(Said 'blast')
							(Said 'use/mrgarbage')
							(Said 'use/garbage<mr')
						)
						(if (gEgo has: 13)
							(proc255_0 90 15)
						else
							(proc255_0 90 16)
						)
					)
					((Said 'find,get/card') (proc255_0 90 17))
					(
					(Said 'look/device,keylock,latch,card,girder,device')
						(if
						(and (== theWHallDoor eHallDoor) (== local3 95))
							(proc255_0 90 18)
						else
							(pEvent claimed: 0)
						)
					)
					((Said '*/device,keylock,latch,girder,device')
						(if
						(and (== theWHallDoor eHallDoor) (== local3 95))
							(proc255_0 90 19)
						else
							(pEvent claimed: 0)
						)
					)
					((Said 'open/door[<corridor]')
						(if
						(and local4 (<= 186 (gEgo x?)) (<= (gEgo x?) 203))
							(proc255_0 90 20)
						else
							(proc255_0 90 21)
						)
					)
					((Said 'close,close/door[<corridor]') (proc255_0 90 22))
					(
						(or
							(Said 'drop,use,insert,enter/card,key')
							(Said 'unlock/door[<corridor]')
						)
						(cond 
							(
								(not
									(if (and local4 (<= 186 (gEgo x?)))
										(<= (gEgo x?) 203)
									)
								)
								(proc255_0 90 23)
							)
							((not (gEgo has: 11)) (proc255_0 90 24))
							((not (User canControl:)) (proc255_0 90 25))
							((not (== (gEgo loop?) 0)) (proc255_0 90 26))
							(
							(or (<= (scanner y?) 90) (>= (scanner y?) 95)) (proc255_0 90 27))
							(else (gEgo setScript: scanScript))
						)
					)
					((Said '*/door') (if local4 (proc255_0 90 28) else (proc255_0 90 29)))
					((Said 'look/crack,crack') (proc255_0 90 30))
					((Said 'explore,look/pocket')
						(if (gEgo has: 12)
							(proc255_0 90 31)
						else
							(proc255_0 90 32)
						)
					)
					(
						(or
							(Said 'copy<use')
							(Said
								'drop,hold,display,use,position,place/original,copy'
							)
						)
						(if (gEgo has: 15)
							(if (== (gEgo view?) 105)
								(gEgo setLoop: 1 setCel: 0 setCycle: End)
								(User canInput: 0)
							else
								(proc255_0 90 33)
							)
						else
							(proc255_0 90 34)
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gTimers eachElementDo: #dispose 84)
		(super newRoom: newRoomNumber)
	)
)

(instance searchScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(searchSound prevSignal: 0)
				(searchSound play:)
				(= cycles 1)
			)
			(1
				(if (!= (searchSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(proc0_3)
					(if (proc0_13 12)
						(proc255_0 90 35)
					else
						(proc255_0 90 36)
					)
				)
			)
			(else  (self init:))
		)
	)
)

(instance scanScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(hallSound stop:)
				(gEgo
					view: 105
					setLoop: 0
					setCel: 0
					x: 202
					setPri: 14
					setCycle: End self
				)
			)
			(1
				(keycardSound play:)
				(Timer setReal: self 2)
			)
			(2 (gEgo setCycle: Beg self))
			(3
				(proc255_0 90 37)
				(proc255_0 90 38)
				(User canInput: 1)
				(gEgo setPri: 13)
				(Timer setReal: self 3)
			)
			(4
				(User canInput: 0)
				(if (== (gEgo loop?) 1)
					(Timer setReal: self 3)
				else
					(= cycles 1)
				)
			)
			(5
				(face init:)
				(scanner setLoop: 6)
				(= local9 6)
				(= cycles 1)
			)
			(6
				(scannerSound play:)
				(face setCel: 0 setCycle: End)
				(scanner setCel: 0 setCycle: End self)
			)
			(7
				(if (-- local9)
					(self changeState: 6)
				else
					(= cycles 1)
				)
			)
			(8
				(face dispose:)
				(scanner setLoop: 5 setCel: 4 setCycle: 0 stopUpd:)
				(Timer setReal: self 2)
			)
			(9
				(if (== (gEgo loop?) 1)
					(= local4 0)
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(10
				(gEgo
					view: 109
					setLoop: -1
					setCel: -1
					setDirection: 3
					setMotion: 0
					setCycle: Walk
				)
				(Timer setCycle: self 3)
			)
			(11
				(if local4 (proc255_0 90 39 67 -1 20 70 280))
				(hallSound play:)
				(proc0_3)
			)
			(12 (self init:))
		)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(gEgo
			view: (if (gEgo has: 13) 109 else 110)
			setPri: 13
			setCel: -1
			setLoop: -1
			setCycle: Walk
			setStep: 3 1
			x: (if (== gNorth 86) 65 else 262)
			y: (if (== gNorth 86) 123 else 119)
			setDirection: (if (== gNorth 86) 3 else 7)
			observeBlocks: egoArea
			init:
		)
		(wHallDoor init:)
		(eHallDoor init:)
		(bPanelLine init:)
		(tPanelLine init:)
		(egoArea init:)
		(scanner init:)
		(hallSound init:)
		(doorSound init:)
		(ouchSound init:)
		(scannerSound init:)
		(keycardSound init:)
		(searchSound init:)
		(hallSound play:)
		(switch gNorth
			(91
				(self changeState: (= state 5))
			)
			(95
				(gGame changeScore: -20)
				(self changeState: (= state 13))
			)
			(86
				(self changeState: (= state 0))
			)
			(else 
				(gEgo posn: 65 123 setDirection: 3)
				(self changeState: (= state 0))
			)
		)
	)
	
	(method (doit)
		(switch (gEgo loop?)
			(0
				(cond 
					((>= (gEgo x?) 203)
						(cond 
							(
								(and
									(> (gEgo y?) (+ 119 (gEgo yStep?)))
									(< (gEgo x?) (+ 203 (gEgo xStep?)))
								)
								(if (== local6 2)
									(gEgo posn: 203 119)
								else
									(gEgo posn: 202 130 setDirection: 0)
									(ShakeScreen 4 2)
									(ouchSound play:)
								)
							)
							((> (gEgo x?) 262)
								(if (== local3 91)
									(gEgo setDirection: 1)
									(global2 newRoom: 91)
								else
									(global2 newRoom: 95)
									(gGame changeScore: 20)
								)
							)
							(else (gEgo y: 119))
						)
					)
					((>= (gEgo x?) 114)
						(if (== (gEgo y?) 123)
							(gEgo y: 130)
						else
							(gEgo y: 130)
							(cond 
								((and (> (gEgo x?) 131) (== local5 0) local7)
									(gEgo setDirection: local7)
									(= local7 0)
									(User canControl: 1)
								)
								((== local6 0)
									(cond 
										((== (eDoorScript state?) 3) (gEgo setScript: eDoorScript))
										((== (eDoorScript state?) 5) (eDoorScript changeState: (- (eDoorScript state?) 1)))
									)
								)
							)
						)
					)
					(else (gEgo y: 123))
				)
			)
			(1
				(cond 
					((<= (gEgo x?) 114)
						(cond 
							(
								(and
									(> (gEgo y?) (+ 123 (gEgo yStep?)))
									(> (gEgo x?) (- 114 (gEgo xStep?)))
								)
								(if (== local5 2)
									(gEgo posn: 114 123)
								else
									(gEgo posn: 115 130 setDirection: 0)
									(ShakeScreen 4 2)
									(ouchSound play:)
								)
							)
							((< (gEgo x?) 65)
								(if (== local3 90)
									(gEgo posn: 65 123)
								else
									(global2 newRoom: 86)
								)
							)
							(else (gEgo y: 123))
						)
					)
					((<= (gEgo x?) 203)
						(if (== (gEgo y?) 119)
							(gEgo y: 130)
						else
							(gEgo y: 130)
							(cond 
								(
								(and (< (gEgo x?) 186) (== local6 0) (!= local7 0))
									(gEgo setDirection: local7)
									(= local7 0)
									(User canControl: 1)
								)
								((== local5 0)
									(cond 
										((== (wDoorScript state?) 2) (gEgo setScript: wDoorScript))
										((== (wDoorScript state?) 4) (wDoorScript changeState: (- (wDoorScript state?) 1)))
									)
								)
							)
						)
					)
					(else (gEgo y: 119))
				)
			)
			(2
				(if (and (< 131 (gEgo x?)) (< (gEgo x?) 186))
					(if
					(and (!= (gEgo y?) 130) (== local5 0) (== local6 0))
						(gEgo posn: (gEgo x?) 130)
						(if (== (theWDoorScript state?) -1)
							(rmScript changeState: (- (rmScript state?) 1))
						)
						(theWDoorScript
							changeState: (- (theWDoorScript state?) 1)
						)
					)
				else
					(User canControl: 0)
					(= local7 5)
					(gEgo setDirection: (if (<= (gEgo x?) 131) 3 else 7))
				)
			)
			(3
				(if (and (< 131 (gEgo x?)) (< (gEgo x?) 186))
					(if
					(and (!= (gEgo y?) 130) (== local5 0) (== local6 0))
						(gEgo posn: (gEgo x?) 130)
						(if
						(== (theWDoorScript state?) (theWDoorScript start?))
							(rmScript cue:)
						)
						(theWDoorScript
							changeState: (+ (theWDoorScript state?) 1)
						)
					)
				else
					(User canControl: 0)
					(= local7 1)
					(gEgo setDirection: (if (<= (gEgo x?) 131) 3 else 7))
				)
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(= theState state)
		(switch (= state newState)
			(0
				(= theWHallDoor wHallDoor)
				(= local3 86)
				(= theWDoorScript wDoorScript)
			)
			(1
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
			)
			(2)
			(3)
			(4
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
			)
			(5
				(= theWHallDoor eHallDoor)
				(= local3 91)
				(= theWDoorScript eDoorScript)
			)
			(6
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
			)
			(7
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
			)
			(8
				(= theWHallDoor wHallDoor)
				(= local3 90)
				(= theWDoorScript wDoorScript)
			)
			(9
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
			)
			(10)
			(11)
			(12
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
				(= local4 0)
			)
			(13
				(= theWHallDoor eHallDoor)
				(= local3 95)
				(= theWDoorScript eDoorScript)
				(if (< (gEgo x?) 203) (= local4 1))
			)
			(14
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
				(= local4 0)
			)
			(15
				(= theWHallDoor bPanelLine)
				(= theWDoorScript panelScript)
			)
			(16
				(= state -1)
				(self changeState: 0)
			)
			(else 
				(= state 16)
				(self changeState: 15)
			)
		)
		(cond 
			((> state theState) (theWDoorScript state: -1))
			((< state theState) (theWDoorScript state: (theWDoorScript start?)))
			(else
				(theWDoorScript
					changeState: (- (theWHallDoor lastCel:) 1)
				)
			)
		)
	)
)

(instance wDoorScript of Script
	(properties
		start 5
	)
	
	(method (changeState newState)
		(wHallDoor posn: 0 0 setCel: newState setPri: 6)
		(switch (= state newState)
			(0 (wHallDoor posn: 119 123))
			(1 (wHallDoor posn: 113 124))
			(2 (wHallDoor posn: 110 127))
			(3 (wHallDoor posn: 104 130))
			(4
				(wHallDoor posn: 93 135 setPri: 14)
			)
			(5 (rmScript cue:))
			(else 
				(rmScript changeState: (- (rmScript state?) 1))
			)
		)
	)
)

(instance eDoorScript of Script
	(properties
		start 6
	)
	
	(method (changeState newState)
		(eHallDoor posn: 0 0 setCel: newState setPri: 5)
		(if (== local3 95)
			(scanner posn: 0 0 setCel: newState setPri: 6)
		)
		(switch (= state newState)
			(0
				(eHallDoor posn: 134 110)
				(if (== local3 95) (scanner posn: 151 85))
			)
			(1
				(eHallDoor posn: 158 116)
				(if (== local3 95) (scanner posn: 176 86))
			)
			(2
				(eHallDoor posn: 177 120)
				(if (== local3 95) (scanner posn: 197 87))
			)
			(3
				(eHallDoor posn: 203 131)
				(if (== local3 95) (scanner posn: 221 89))
			)
			(4
				(eHallDoor posn: 213 136)
				(if (== local3 95) (scanner posn: 229 91 setPri: 14))
			)
			(5
				(eHallDoor posn: 226 131 setPri: 14)
			)
			(6 (rmScript cue:))
			(else 
				(rmScript changeState: (- (rmScript state?) 1))
			)
		)
	)
)

(instance panelScript of Script
	(properties
		start 8
	)
	
	(method (changeState newState)
		(bPanelLine posn: 0 0)
		(tPanelLine posn: 0 0)
		(switch (= state newState)
			(0)
			(1
				(bPanelLine posn: 158 115)
				(tPanelLine posn: 158 50)
			)
			(2
				(bPanelLine posn: 158 119)
				(tPanelLine posn: 158 47)
			)
			(3
				(bPanelLine posn: 158 123)
				(tPanelLine posn: 158 43)
			)
			(4
				(bPanelLine posn: 158 127)
				(tPanelLine posn: 158 40)
			)
			(5
				(bPanelLine posn: 158 133)
				(tPanelLine posn: 158 37)
			)
			(6
				(bPanelLine posn: 158 135)
				(tPanelLine posn: 158 34)
			)
			(7)
			(8 (rmScript cue:))
			(else 
				(rmScript changeState: (- (rmScript state?) 1))
			)
		)
	)
)

(instance wHallDoor of Prop
	(properties
		view 111
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 0 posn: 0 0 setPri: 6)
		(= local5 0)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((and (<= 75 (gEgo x?)) (<= (gEgo x?) 131))
				(if (and (== (self loop?) 0) (== (self cel?) 3))
					(self setLoop: 1 setCel: 0)
					(= local5 1)
				)
				(if (== local5 1)
					(= local5 3)
					(doorSound play:)
					(self setCycle: End self)
				)
			)
			((or (== local5 3) (== local5 2)) (= local5 1) (doorSound play:) (self setCycle: Beg self))
		)
	)
	
	(method (cue)
		(if (== local5 1)
			(= local5 0)
			(wHallDoor setLoop: 0 setCel: 3 startUpd:)
		else
			(= local5 2)
			(wHallDoor stopUpd:)
		)
	)
)

(instance eHallDoor of Prop
	(properties
		view 111
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 2 posn: 0 0 setPri: 5)
		(= local6 0)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((and (<= 186 (gEgo x?)) (<= (gEgo x?) 252))
				(if
					(and
						(== (self loop?) 2)
						(== (self cel?) 4)
						(not local4)
					)
					(= local6 1)
					(self setLoop: 3 setCel: 0)
				)
				(if (== local6 1)
					(= local6 3)
					(doorSound play:)
					(self setCycle: End self)
				)
			)
			((or (== local6 3) (== local6 2)) (= local6 1) (doorSound play:) (self setCycle: Beg self))
		)
	)
	
	(method (cue)
		(if (== local6 1)
			(= local6 0)
			(self setLoop: 2 setCel: 4 startUpd:)
			(if (and (== local3 95) (< (gEgo x?) 203))
				(= local4 1)
			)
		else
			(= local6 2)
			(self stopUpd:)
		)
	)
)

(instance tPanelLine of Prop
	(properties
		view 111
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 4 posn: 0 0 setPri: 4)
	)
)

(instance bPanelLine of Prop
	(properties
		view 111
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 4 setPri: 4)
	)
)

(instance scanner of Prop
	(properties
		view 111
		loop 5
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 setPri: 6)
	)
)

(instance face of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 14
			view: 105
			x: (if (== (gEgo loop?) 1) 219 else 202)
			y: (if (== (gEgo loop?) 1) 81 else 80)
			setLoop: (if (== (gEgo loop?) 1) 3 else 2)
		)
	)
)

(instance egoArea of Cage
	(properties
		top 117
		bottom 132
		right 320
	)
)

(instance hallSound of Sound
	(properties
		number 14
		loop -1
	)
)

(instance doorSound of Sound
	(properties
		number 49
		priority 1
	)
)

(instance ouchSound of Sound
	(properties
		number 57
		priority 1
	)
)

(instance scannerSound of Sound
	(properties
		number 67
		priority 1
	)
)

(instance keycardSound of Sound
	(properties
		number 74
		priority 1
	)
)

(instance searchSound of Sound
	(properties
		number 60
		priority 1
	)
)
