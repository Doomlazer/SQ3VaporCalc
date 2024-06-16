;;; Sierra Script 1.0 - (do not remove this comment)
(script# 29)
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
	rm29 0
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
(instance rm29 of Rm
	(properties
		picture 29
		east 28
	)
	
	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(Load rsVIEW 56)
		(Load rsVIEW 57)
		(Load rsVIEW 59)
		(Load rsVIEW 85)
		(super init:)
		(door init: stopUpd:)
		(clerk init: stopUpd:)
		(gEgo init:)
		(bully init: stopUpd:)
		(if (> global124 0)
			(al3 init: stopUpd: setScript: al3Script)
			(al1Head init: stopUpd: setScript: (al1Script new:))
			(al2Head init: stopUpd: setScript: (al1Script new:))
		else
			(al3 init: addToPic:)
			(al1Head init: addToPic:)
			(al2Head init: addToPic:)
		)
		(gAddToPics add: al1 al2 machine)
		(gAddToPics doit:)
		(= local0 2)
		(= local4 0)
		(= local6 1)
		(= local7 1)
		(switch gNorth
			(25
				(proc0_3)
				(gEgo init: loop: 3 cel: 0 posn: 286 130)
				(if (and global247 global248)
					(proc0_2)
					(= global248 0)
					(global2 setScript: makeBurger)
				)
				(= local1 1)
				(gLongSong number: 16 loop: -1 play:)
			)
			(28
				(proc0_3)
				(gEgo init:)
				(if (< (gEgo y?) 110) (gEgo posn: 200 100))
			)
			(280
				(proc0_3)
				(gEgo init: posn: gGEgoX_3 gGEgoY_2)
				(gLongSong number: 16 loop: -1 play:)
			)
			(290
				(TheMenuBar draw:)
				(SL enable:)
				(proc0_3)
				(proc0_1 0 0)
				(gEgo posn: 172 111)
				(gLongSong number: 16 loop: -1 play:)
			)
			(else 
				(gEgo init: posn: 172 111)
			)
		)
	)
	
	(method (doit)
		(super doit:)
		(if
			(or
				(== (gEgo onControl: 0) 4)
				(== (gEgo onControl: 0) 5)
			)
			(global2 newRoom: 28)
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
		(if (gEgo inRect: 282 125 319 135)
			(cond 
				(global247
					(if
						(and
							(not local1)
							(not global248)
							(not (gEgo has: 17))
						)
						(global2 newRoom: 25)
					)
				)
				((and (not local2) (not local1)) (proc255_0 29 0) (= local2 1))
			)
		else
			(= local1 0)
			(= local2 0)
		)
		(if (and (== (gEgo onControl: 1) 8) (not script))
			(global2 setScript: Bully)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 50])
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look>')
						(cond 
							((or (Said '/pane') (Said '<out')) (proc255_0 29 1))
							((or (Said '/deck,ceiling') (Said '<up,down')) (proc255_0 29 2))
							((Said '/partition') (proc255_0 29 3))
							((Said '/clerk') (proc255_0 29 4))
							(
							(Said '/alien,being,man,bystander,folk,animal,customer') (proc255_0 29 5))
							((Said '/craft') (proc255_0 29 6))
							((Said '/counter') (proc255_0 29 7))
							((Said '/door') (proc255_0 29 8))
							((Said '/menace') (proc255_0 29 9))
							((Said '/dinner,bag,drink')
								(cond 
									((gEgo has: 17) (pEvent claimed: 0))
									((== local7 0) (proc255_0 29 10))
									(else (proc255_0 29 11))
								)
							)
							(
								(or
									(Said '/astro,astro,grafitti,game,device,comp[<grafitti]')
									(Said '/astro<astro')
								)
								(if (gEgo inRect: 158 94 200 124)
									(global2 newRoom: 290)
								else
									(proc255_0 29 12)
								)
							)
							((Said '/table,chair,booth') (proc255_0 29 13))
							((Said '/menu')
								(if (== local6 0)
									(proc255_0 29 14)
								else
									(= gGEgoX_3 (gEgo x?))
									(= gGEgoY_2 (gEgo y?))
									(global2 newRoom: 280)
								)
							)
							((Said '[<around,at,in][/area,cafe]') (proc255_0 29 15))
						)
					)
					((Said 'open,close/door') (proc255_0 29 16))
					(
						(or
							(Said 'play/astro,astro,grafitti,game,device[<grafitti]')
							(Said 'play/astro<astro')
						)
						(if (gEgo inRect: 158 94 200 124)
							(global2 newRoom: 290)
						else
							(proc255_0 29 12)
						)
					)
					(
					(Said 'beat,tilt/grafitti,game,device[<grafitti]')
						(if (gEgo inRect: 158 94 200 124)
							(proc255_0 29 17)
						else
							(proc255_0 29 12)
						)
					)
					(
						(or
							(Said 'order,buy,get,ask[/dinner,dinner,burger,drink]')
							(Said 'converse/clerk')
						)
						(cond 
							((not (gEgo inRect: 282 125 319 135)) (proc255_0 29 18))
							((gEgo has: 17) (proc255_0 29 19))
							((not global248) (global2 newRoom: 25))
							(else (proc255_0 29 0))
						)
					)
					((Said 'read/menu')
						(if (== local6 0)
							(proc255_0 29 14)
						else
							(= gGEgoX_3 (gEgo x?))
							(= gGEgoY_2 (gEgo y?))
							(global2 newRoom: 280)
						)
					)
					((Said 'read/menace') (proc255_0 29 9))
					(
						(Said
							'ask,converse/alien,being,man,bystander,folk,animal,customer'
						)
						(proc255_0 29 20)
					)
					((Said 'converse') (proc255_0 29 21))
					(
						(Said
							'kiss/alien,being,man,bystander,folk,animal,customer'
						)
						(proc255_0 29 22)
					)
					(
						(Said
							'smell[/man,alien,being,him,bystander,animal,customer]'
						)
						(proc255_0 29 23)
					)
					((Said 'down,sit[<down]')
						(cond 
							((== local6 0) (proc255_0 29 24))
							((gEgo inRect: 173 123 232 156) (global2 setScript: SitDown))
							(else (proc255_0 29 25))
						)
					)
					((Said 'up,(get<up),stand[/up]')
						(if (== local6 1)
							(proc255_0 29 26)
						else
							(global2 setScript: StandUp)
						)
					)
					((Said 'eat[<dinner]')
						(cond 
							((!= local6 0) (proc255_0 29 27))
							((gEgo has: 17) (global2 setScript: EgoEating))
							(else (proc255_0 29 28))
						)
					)
					((Said 'get[<up]/bag')
						(cond 
							((gEgo has: 17) (proc255_0 29 29))
							((== local7 0) (proc255_0 29 30))
							(else (proc255_0 29 31))
						)
					)
					(
						(or
							(Said 'throw,get[<up,away]/garbage')
							(Said 'clean/table')
						)
						(cond 
							((gEgo has: 17) (proc255_0 29 32))
							((== local7 0) (proc255_0 29 30))
							(else (proc255_0 29 33))
						)
					)
				)
			)
			(evJOYSTICK
				(if (== local6 0)
					(switch (pEvent message?)
						(JOY_UP
							(global2 setScript: StandUp)
							(pEvent claimed: 1)
						)
						(JOY_RIGHT
							(global2 setScript: StandUp)
							(pEvent claimed: 1)
						)
						(JOY_DOWN
							(pEvent claimed: 1)
							(return)
						)
						(JOY_UPLEFT
							(pEvent claimed: 1)
							(return)
						)
						(JOY_UPRIGHT
							(global2 setScript: StandUp)
							(pEvent claimed: 1)
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
							(pEvent claimed: 1)
							(return)
						)
						(JOY_NULL
							(pEvent claimed: 1)
							(return)
						)
					)
				)
			)
			(evMOUSEBUTTON
				(if (== local6 0)
					(global2 setScript: StandUp)
					(pEvent claimed: 1)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 28) (gLongSong stop:))
		(super newRoom: newRoomNumber)
	)
)

(instance makeBurger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerk setLoop: 3 setMotion: MoveTo 248 103 self)
			)
			(1 (= seconds 2))
			(2
				(clerk setLoop: 4 setMotion: MoveTo 297 105 self)
			)
			(3
				(clerk setLoop: 1)
				(= seconds 2)
			)
			(4
				(clerk setLoop: 0)
				(bag init:)
				(balloon init:)
				(= seconds 4)
			)
			(5
				(balloon dispose:)
				(bag dispose:)
				(proc255_0 29 34)
				(gEgo get: 17)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance SitDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo illegalBits: 0 setMotion: MoveTo 186 141 self)
			)
			(1
				(gEgo view: 85 setLoop: 7 setPri: 15 setCel: 0)
				(if (gEgo has: 17)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
			)
			(2
				(proc0_3)
				(= local6 0)
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
				(if (== local7 0) (bag2 init:) (gEgo put: 17))
				(gEgo setLoop: 7 setCel: 4 setCycle: Beg self)
			)
			(1
				(gEgo posn: 191 139)
				(proc0_10)
				(proc0_1 2 0)
				(= local6 1)
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
				(= local6 2)
				(= local5 7)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(cond 
					((!= (-- local5) 0)
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
				(proc255_0 29 35)
				(gEgo get: 7)
				(gGame changeScore: 10)
				(= seconds 3)
			)
			(34 (self changeState: 40))
			(40
				(proc255_0 29 36)
				(gEgo setCycle: 0)
				(User canInput: 1)
				(= global159 0)
				(= global249 0)
				(= global244 0)
				(gEgo put: 17)
				(= local7 0)
				(= local6 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance Bully of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local4)
					(= local4 1)
					(proc0_2)
					(bBalloon init:)
					(= seconds 3)
				else
					(proc0_2)
					(self changeState: 20)
				)
			)
			(1
				(bBalloon dispose:)
				(ShakeScreen 5)
				(pow init: setCycle: End)
				(door setCycle: End self)
			)
			(2
				(gEgo
					view: 57
					setLoop: 5
					setCel: 0
					posn: 146 89
					xStep: 5
					yStep: 3
					cycleSpeed: 1
					setCycle: End
					setMotion: MoveTo 169 113 self
					ignoreControl: 1
				)
			)
			(3
				(stars init: setCycle: Fwd)
				(pow
					setLoop: 4
					setCel: 0
					posn: (gEgo x?) (+ (gEgo y?) 5)
					setPri: 15
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(4 (pow dispose:) (= cycles 2))
			(5
				(bully setCycle: Walk setMotion: MoveTo 146 89 self)
			)
			(6
				(bully setMotion: MoveTo 158 97 self)
			)
			(7
				(door setCycle: Beg)
				(bully setMotion: MoveTo 209 97 self)
			)
			(8
				(bully stopUpd:)
				(stars dispose:)
				(gEgo setLoop: 6 setCycle: End self)
			)
			(9
				(proc0_1 1 0)
				(proc0_3)
				(global2 setScript: 0)
			)
			(20
				(door setCycle: End)
				(bully setCycle: Walk setMotion: MoveTo 158 97 self)
			)
			(21
				(bully setMotion: MoveTo 146 89 self)
			)
			(22
				(bully setMotion: MoveTo 122 89 self)
			)
			(23 (door setCycle: Beg self))
			(24
				(bBalloon init: setCel: 1)
				(= seconds 3)
			)
			(25
				(bBalloon dispose:)
				(ShakeScreen 5)
				(pow
					init:
					setLoop: 3
					setCel: 0
					posn: 145 81
					setPri: 15
					setCycle: End
				)
				(= seconds 2)
			)
			(26 (proc0_17 0 0 10 12))
		)
	)
)

(instance al1Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 10)))
			(1
				(if
				(or local3 (!= (gEgo mover?) 0) (!= (rm29 script?) 0))
					(self changeState: 5)
				else
					(= cycles 2)
				)
			)
			(2
				(= local3 1)
				(client setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(client stopUpd:)
				(= local3 0)
				(= seconds (Random 10 20))
			)
			(4 (self changeState: 1))
			(5 (= cycles 2))
			(6 (self changeState: 1))
		)
	)
)

(instance al3Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 14)))
			(1
				(if
				(or local3 (!= (gEgo mover?) 0) (!= (rm29 script?) 0))
					(self changeState: 6)
				else
					(= cycles 2)
				)
			)
			(2
				(= local3 1)
				(client setCycle: End)
				(= seconds 2)
			)
			(3 (client setCycle: Beg self))
			(4
				(client stopUpd:)
				(= local3 0)
				(= seconds (Random 10 20))
			)
			(5 (self changeState: 1))
			(6 (= cycles 2))
			(7 (self changeState: 1))
		)
	)
)

(instance clerk of Act
	(properties)
	
	(method (init)
		(super init:)
		(self view: 59 loop: 0 posn: 297 105 ignoreActors: 1)
	)
)

(instance bag of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 59
			setLoop: 2
			setCel: 0
			posn: 295 108
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance bag2 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 85
			setLoop: 6
			setCel: 0
			posn: 177 153
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance balloon of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 59
			setLoop: 5
			setCel: 0
			posn: 297 85
			ignoreActors: 1
		)
	)
)

(instance bully of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 57
			loop: 0
			posn: 122 89
			ignoreActors: 1
			setStep: 3 2
		)
	)
)

(instance bBalloon of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 57
			setLoop: 2
			setCel: 0
			posn: 177 88
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance pow of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 57
			setLoop: 3
			setCel: 0
			posn: 145 81
			setPri: 15
		)
	)
)

(instance stars of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 57
			setLoop: 7
			setCel: 0
			posn: (+ (gEgo x?) 3) (- (gEgo y?) 9)
			setPri: (+ (gEgo priority?) 1)
		)
	)
)

(instance al1 of PV
	(properties
		y 164
		x 237
		view 56
		loop 1
		cel 1
		priority 15
		signal $4000
	)
)

(instance al2 of PV
	(properties
		y 134
		x 140
		view 56
		loop 1
		cel 2
		priority 15
		signal $4000
	)
)

(instance machine of PV
	(properties
		y 111
		x 190
		view 56
		loop 1
	)
)

(instance al3 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 4
			setCel: 0
			posn: 289 170
			setPri: 15
		)
	)
)

(instance al1Head of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 2
			setCel: 0
			posn: 141 119
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance al2Head of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 3
			setCel: 0
			posn: 226 149
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance door of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 0
			setCel: 0
			posn: 156 95
			setPri: 6
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(if (not (rm29 script?))
			(cond 
				(
					(or
						(== (gEgo onControl: 0) 2)
						(== (gEgo onControl: 0) 3)
					)
					(if (> local0 1)
						(= local0 1)
						(self setCycle: End self)
					)
				)
				((< local0 2) (= local0 3) (self setCycle: Beg self))
			)
		)
	)
	
	(method (cue)
		(door stopUpd:)
		(= local0 (if (== local0 1) 0 else 2))
	)
)
