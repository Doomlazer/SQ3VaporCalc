;;; Sierra Script 1.0 - (do not remove this comment)
(script# 28)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm028 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)
(instance rm028 of Rm
	(properties
		picture 28
		west 29
	)
	
	(method (init &tmp [temp0 50])
		(Load rsVIEW 43)
		(Load rsVIEW 44)
		(Load rsVIEW 53)
		(Load rsVIEW 64)
		(Load rsVIEW 137)
		(Load rsVIEW 213)
		(Load rsSOUND 16)
		(super init:)
		(gAddToPics add: al2 al3 al5 al4 slop sa3)
		(gAddToPics doit:)
		(ship init:)
		(collar init: stopUpd:)
		(door init: stopUpd:)
		(if (> global124 0)
			(al1 init: setScript: AlienScript)
			(arm init: stopUpd:)
			(tail init: stopUpd:)
			(sa2 init: stopUpd:)
			(sa3Mouth init: stopUpd:)
			(sa1 init: stopUpd: setScript: sa1Script)
		else
			(al1 init: addToPic:)
			(arm init: addToPic:)
			(tail init: addToPic:)
			(sa1 init: addToPic:)
			(sa2 init: addToPic:)
			(sa3Mouth init: addToPic:)
		)
		(= local1 2)
		(= local4 1)
		(= local5 1)
		(= global244 0)
		(= global247 1)
		(gLongSong number: 16)
		(if (and (!= gNorth 29) (!= gNorth 27))
			(gLongSong play:)
		)
		(switch gNorth
			(17
				(collar setCel: 7)
				(ship x: 335 y: 174)
				(chairMan setCel: 0)
				(proc0_2)
				(= global206 1)
				(= local0 4)
				(self setScript: dockScript)
			)
			(19
				(ship x: 335 y: 174)
				(collar setCel: 7)
				(chairMan setCel: 0)
				(proc0_2)
				(= global206 1)
				(= local0 4)
				(self setScript: dockScript)
			)
			(27
				(collar setCel: 7)
				(ship x: 335 y: 174)
				(chairMan setCel: 0)
				(proc0_2)
				(= global206 1)
				(= local0 4)
				(self setScript: dockScript)
			)
			(29
				(proc0_3)
				(collar setCel: 0)
				(ship x: 286 y: 115)
				(chairMan setCel: 7 init:)
				(ship stopUpd:)
				(= global206 0)
				(= local0 1)
				(gEgo init:)
				(if (< (gEgo y?) 110) (gEgo posn: 120 100))
			)
			(280
				(collar setCel: 0)
				(ship x: 286 y: 115 stopUpd:)
				(chairMan setCel: 7 init:)
				(proc0_3)
				(gEgo init: posn: gGEgoX_3 gGEgoY_2)
				(ship stopUpd:)
				(= global206 0)
				(= local0 1)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)
	
	(method (doit)
		(super doit:)
		(if
			(or
				(== (gEgo onControl: 0) 4)
				(== (gEgo onControl: 0) 5)
			)
			(global2 newRoom: 29)
		)
		(if
			(and
				(or
					(== (gEgo onControl: 0) 16)
					(== (gEgo onControl: 0) 17)
				)
				(not script)
			)
			(global2 setScript: SitDown)
		)
		(if
		(and (== script 0) (gEgo inRect: 0 125 68 138))
			(rm028 setScript: CrowdScript)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 50])
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look>')
						(cond 
							((or (Said '/pane') (Said '<out')) (proc255_0 28 0))
							((or (Said '/deck,ceiling') (Said '<up,down')) (proc255_0 28 1))
							((Said '/partition') (proc255_0 28 2))
							((Said '/clerk') (proc255_0 28 3))
							((Said '/alien,being,man,bystander,folk,animal') (proc255_0 28 4))
							((Said '/craft') (proc255_0 28 5))
							((Said '/door') (proc255_0 28 6))
							((Said '/dinner,bag,drink')
								(cond 
									((gEgo has: 17) (pEvent claimed: 0))
									((== local5 0) (proc255_0 28 7))
									(else (proc255_0 28 8))
								)
							)
							((Said '/table,chair,booth') (proc255_0 28 9))
							((Said '/counter') (proc255_0 28 10))
							((Said '/menu')
								(if (== local4 0)
									(proc255_0 28 11)
								else
									(= gGEgoX_3 (gEgo x?))
									(= gGEgoY_2 (gEgo y?))
									(global2 newRoom: 280)
								)
							)
							((Said '[<around,at,in][/area,cafe]') (proc255_0 28 12))
						)
					)
					((Said 'down,sit[<down]')
						(cond 
							((== local4 0) (proc255_0 28 13))
							((gEgo inRect: 136 115 178 140) (global2 setScript: SitDown))
							((gEgo inRect: 0 145 37 171) (proc255_0 28 14))
							(else (proc255_0 28 15))
						)
					)
					((Said 'up,(get<up),stand[/up]')
						(if (== local4 1)
							(proc255_0 28 16)
						else
							(global2 setScript: StandUp)
						)
					)
					((Said 'eat[<dinner]')
						(cond 
							((!= local4 0) (proc255_0 28 17))
							((gEgo has: 17) (global2 setScript: EgoEating))
							(else (proc255_0 28 18))
						)
					)
					((Said 'get[<up]/bag')
						(cond 
							((gEgo has: 17) (proc255_0 28 19))
							((== local5 0) (proc255_0 28 20))
							(else (proc255_0 28 21))
						)
					)
					(
						(or
							(Said 'throw,get[<up,away]/garbage')
							(Said 'clean/table')
						)
						(cond 
							((gEgo has: 17) (proc255_0 28 22))
							((or (== local5 0) (gEgo inRect: 0 145 37 171)) (proc255_0 28 20))
							(else (proc255_0 28 23))
						)
					)
					((Said 'open,close/door') (proc255_0 28 24))
					(
						(or
							(Said 'order,buy,get,ask[/dinner,dinner,burger]')
							(Said 'converse/clerk')
						)
						(proc255_0 28 25)
					)
					(
						(Said
							'ask,converse/alien,being,man,bystander,folk,animal,customer'
						)
						(proc255_0 28 26)
					)
					((Said 'converse') (proc255_0 28 27))
					(
						(Said
							'kiss/alien,being,man,bystander,folk,animal,customer'
						)
						(proc255_0 28 28)
					)
					(
						(Said
							'smell[/man,being,alien,him,bystander,animal,customer]'
						)
						(proc255_0 28 29)
					)
					(
						(Said
							'beat[/man,being,alien,him,bystander,animal,customer]'
						)
						(proc255_0 28 30)
					)
					((Said 'read/menu')
						(if (== local4 0)
							(proc255_0 28 11)
						else
							(= gGEgoX_3 (gEgo x?))
							(= gGEgoY_2 (gEgo y?))
							(global2 newRoom: 280)
						)
					)
					(
						(or
							(Said 'open,enter,board,climb,(get<in)[/door,door,craft]')
							(Said 'disembark')
						)
						(cond 
							((not (gEgo inRect: 179 72 251 95)) (proc255_0 28 31))
							((gEgo has: 17) (proc255_0 28 32))
							(global101 (self setScript: VomitScript))
							(else (self setScript: OutScript))
						)
					)
				)
			)
			(evJOYSTICK
				(if (== local4 0)
					(switch (pEvent message?)
						(JOY_UP
							(global2 setScript: StandUp)
							(pEvent claimed: 1)
						)
						(JOY_RIGHT
							(pEvent claimed: 1)
							(return)
						)
						(JOY_DOWN
							(pEvent claimed: 1)
							(return)
						)
						(JOY_UPLEFT
							(global2 setScript: StandUp)
							(pEvent claimed: 1)
						)
						(JOY_UPRIGHT
							(pEvent claimed: 1)
							(return)
						)
						(JOY_DOWNRIGHT
							(pEvent claimed: 1)
							(return)
						)
						(JOY_DOWNLEFT
							(pEvent claimed: 1)
							(return)
						)
						(JOY_LEFT
							(global2 setScript: StandUp)
							(pEvent claimed: 1)
						)
						(JOY_NULL
							(pEvent claimed: 1)
							(return)
						)
					)
				)
			)
			(evMOUSEBUTTON
				(if (and (== local4 0) (not (pEvent claimed?)))
					(global2 setScript: StandUp)
					(pEvent claimed: 1)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 29) (gLongSong fade:))
		(super newRoom: newRoomNumber)
	)
)

(instance SitDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 213
					illegalBits: 0
					posn: 168 127
					setLoop: 7
					setPri: 14
					setCel: 0
				)
				(if (gEgo has: 17)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
			)
			(1
				(proc0_3)
				(= local4 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance StandUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (== local5 0) (bag2 init: stopUpd:) (gEgo put: 17))
				(gEgo setLoop: 7 setCel: 4 setCycle: Beg self)
			)
			(1
				(proc0_10)
				(proc0_1 2 0)
				(gEgo posn: 166 125)
				(= local4 1)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance EgoEating of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(= local6 7)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(cond 
					((!= (-- local6) 0)
						(switch (Random 1 2)
							(1 (self changeState: 10))
							(2 (self changeState: 20))
						)
					)
					(global249 (self changeState: 30))
					(else (self changeState: 40))
				)
			)
			(10
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(11 (gEgo setCycle: Beg self))
			(12
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 2)
			)
			(13
				(gEgo setLoop: 3 setCycle: End self)
			)
			(14
				(gEgo setLoop: 2 setCel: 0)
				(= cycles 10)
			)
			(15 (self changeState: 1))
			(20
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(21
				(gEgo setLoop: 5 setCycle: Fwd)
				(= seconds 3)
			)
			(22
				(gEgo setLoop: 4 setCel: 2 setCycle: Beg self)
			)
			(23
				(gEgo setLoop: 2 setCel: 0)
				(= cycles 10)
			)
			(24 (self changeState: 1))
			(30
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(31 (gEgo setCycle: Beg self))
			(32
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(33
				(proc255_0 28 33)
				(gEgo get: 7)
				(gGame changeScore: 10)
				(= seconds 3)
			)
			(34 (self changeState: 40))
			(40
				(proc255_0 28 34)
				(gEgo setCycle: 0)
				(User canInput: 1)
				(= global159 0)
				(= global249 0)
				(= global244 0)
				(gEgo put: 17)
				(= local5 0)
				(= local4 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance dockScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship setMotion: MoveTo 286 125 self)
			)
			(1
				(ship setMotion: MoveTo 286 115 self)
			)
			(2
				(collar setCycle: Beg self startUpd:)
				(ship stopUpd:)
			)
			(3
				(collar stopUpd:)
				(= global206 0)
				(= seconds 2)
			)
			(4
				(proc255_0 28 35 67 -1 130 70 280)
				(proc0_3)
				(= cycles 2)
			)
			(5
				(chairMan init: setCycle: End self)
			)
			(6
				(chairMan stopUpd:)
				(= seconds 2)
			)
			(7
				(proc255_0 28 36)
				(gEgo
					view: 0
					setLoop: -1
					loop: 1
					posn: 173 93
					setStep: 3 2
					setCycle: Walk
					illegalBits: -32768
					setPri: -1
					init:
				)
				(if (gCast contains: gEgo)
					(gEgo show:)
				else
					(gEgo init:)
				)
				(proc0_3)
				(= local0 1)
				(global2 setScript: 0)
			)
		)
	)
)

(instance OutScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 202 82 self)
			)
			(1
				(= global159 1)
				(chairMan setCycle: Beg self)
				(gEgo hide:)
			)
			(2
				(= local0 4)
				(chairMan dispose:)
				(proc0_10)
				(proc255_0 28 37 67 -1 130 70 280)
				(ship setMotion: MoveTo 286 125 self)
			)
			(3
				(ship setMotion: MoveTo 335 174 self)
			)
			(4
				(= global206 3)
				(= global159 0)
				(global2 newRoom: 14)
			)
		)
	)
)

(instance VomitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 137
					setLoop: 0
					illegalBits: 0
					setMotion: MoveTo 168 93 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 134 105 self)
			)
			(2
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3 (= cycles 10))
			(4 (gEgo setCycle: End self))
			(5 (= cycles 10))
			(6 (gEgo setCycle: End self))
			(7
				(gEgo
					view: 0
					loop: 1
					setLoop: -1
					illegalBits: -32768
					setCycle: Walk
				)
				(= seconds 2)
			)
			(8
				(proc255_0 28 38)
				(= global101 0)
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance CrowdScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(pow
					init:
					setPri: 14
					posn: (gEgo x?) (- (gEgo y?) 40)
					setCycle: End self
				)
				(gEgo
					view: 64
					setLoop: 2
					setCel: 0
					setCycle: End self
					xStep: 6
					setMotion: MoveTo (+ (gEgo x?) 30) (gEgo y?)
				)
			)
			(1
				(pow dispose:)
				(balloon
					init:
					setPri: 14
					posn: (gEgo x?) (- (gEgo y?) 40)
				)
				(= seconds 2)
			)
			(2
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(balloon dispose:)
				(gEgo
					view: 0
					setLoop: -1
					loop: 1
					setCycle: Walk
					cycleSpeed: 0
					xStep: 3
					setDirection: 0
				)
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance AlienScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 10)))
			(1
				(if
					(or
						local2
						(!= (gEgo mover?) 0)
						(!= (rm028 script?) 0)
					)
					(self changeState: 4)
				else
					(= cycles 2)
				)
			)
			(2
				(= local2 1)
				(switch (= local7 (Random 0 4))
					(0 (al1 setCycle: Fwd))
					(1 (arm setCycle: Fwd))
					(2 (tail setCycle: Fwd))
					(3 (sa2 setCycle: Fwd))
					(4 (sa3Mouth setCycle: Fwd))
				)
				(= seconds 3)
			)
			(3
				(switch local7
					(0 (al1 setCycle: 0 stopUpd:))
					(1 (arm setCycle: 0 stopUpd:))
					(2 (tail setCycle: 0 stopUpd:))
					(3 (sa2 setCycle: 0 stopUpd:))
					(4
						(sa3Mouth setCycle: 0 stopUpd:)
					)
				)
				(= local2 0)
				(= cycles 2)
			)
			(4 (= cycles 2))
			(5 (self changeState: 1))
		)
	)
)

(instance sa1Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 1 5)))
			(1
				(if
					(or
						local2
						(!= (gEgo mover?) 0)
						(!= (rm028 script?) 0)
					)
					(self changeState: 13)
				else
					(= cycles 2)
				)
			)
			(2
				(= local2 1)
				(switch (Random 1 3)
					(1 (self changeState: 3))
					(2 (self changeState: 6))
					(3 (self changeState: 9))
				)
			)
			(3
				(sa1 setLoop: 0 setCycle: End)
				(= seconds 3)
			)
			(4 (sa1 setCycle: Beg self))
			(5 (self changeState: 12))
			(6
				(sa1 setLoop: 1 setCycle: End self)
			)
			(7
				(sa1 setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(sa1 setLoop: 0)
				(self changeState: 12)
			)
			(9
				(sa1 setLoop: 3 setCycle: End self)
			)
			(10
				(sa1 setLoop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(11
				(sa1 setLoop: 0)
				(self changeState: 12)
			)
			(12
				(sa1 setLoop: 0 setCycle: 0 stopUpd:)
				(= local2 0)
				(= seconds (Random 10 20))
			)
			(13 (= cycles 2))
			(14 (self changeState: 1))
		)
	)
)

(instance bag2 of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 213
			setLoop: 6
			setCel: 0
			posn: 176 140
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance collar of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 44
			setLoop: 0
			posn: 286 90
			setPri: 6
			ignoreActors: 1
		)
	)
)

(instance ship of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 44
			setLoop: 1
			setPri: 5
			setStep: 1 1
			illegalBits: 0
			ignoreActors: 1
		)
	)
)

(instance al1 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			x: 30
			y: 128
			view: 43
			setLoop: 1
			setCel: 0
			setPri: 8
		)
	)
)

(instance al2 of PV
	(properties
		y 137
		x 42
		view 43
		loop 2
		priority 10
	)
)

(instance al3 of PV
	(properties
		y 137
		x 11
		view 43
		loop 3
		priority 10
	)
)

(instance al4 of PV
	(properties
		y 137
		x 69
		view 43
		loop 4
	)
)

(instance al5 of PV
	(properties
		y 121
		x 95
		view 43
		loop 4
		cel 1
	)
)

(instance slop of PV
	(properties
		y 171
		x 22
		view 43
		loop 7
		priority 15
		signal $4000
	)
)

(instance sa3 of PV
	(properties
		y 145
		x 145
		view 53
		loop 6
		priority 14
	)
)

(instance arm of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 43
			setLoop: 5
			setCel: 0
			x: 70
			y: 128
			setPri: 10
		)
	)
)

(instance tail of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 43
			setLoop: 6
			setCel: 0
			x: 123
			y: 125
			setPri: 8
		)
	)
)

(instance sa1 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 53
			setLoop: 0
			setCel: 0
			x: 88
			y: 160
			setPri: 14
		)
	)
)

(instance sa2 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 53
			setLoop: 5
			setCel: 0
			x: 118
			y: 151
			setPri: 14
		)
	)
)

(instance sa3Mouth of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 53
			setLoop: 7
			setCel: 0
			x: 141
			y: 142
			setPri: 15
		)
	)
)

(instance chairMan of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 44
			setLoop: 2
			posn: 263 109
			setPri: 6
			ignoreActors: 1
		)
	)
)

(instance pow of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self view: 64 setLoop: 0 setCel: 0 ignoreActors: 1)
	)
)

(instance balloon of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self view: 64 setLoop: 1 setCel: 0 ignoreActors: 1)
	)
)

(instance door of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 43
			setLoop: 0
			setCel: 0
			posn: 164 95
			setPri: 6
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(
				(or
					(== (gEgo onControl: 0) 2)
					(== (gEgo onControl: 0) 3)
				)
				(if (> local1 1)
					(= local1 1)
					(self setCycle: End self)
				)
			)
			((< local1 2) (= local1 3) (self setCycle: Beg self))
		)
	)
	
	(method (cue)
		(door stopUpd:)
		(= local1 (if (== local1 1) 0 else 2))
	)
)
