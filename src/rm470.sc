;;; Sierra Script 1.0 - (do not remove this comment)
(script# 470)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm470 0
)

(local
	local0
	local1
	local2
	eyesCel
)
(procedure (localproc_16e2)
	(= global193 1)
	(rHand setCycle: 0)
	(= local2 1)
	(balloon setCel: 1)
	(ArmUp changeState: 0)
	(mouth setCycle: Fwd)
)

(procedure (localproc_1714 param1 param2 param3 param4 param5)
	(lHand hide:)
	(lArm setCel: 0)
	(proc0_10)
	(= local2 1)
	(head cel: 1)
	(eyes posn: 150 58 setCel: 2)
	(lArm view: 81 setLoop: 0 setCel: 0)
	(lHand
		view: 81
		setLoop: param1
		setCel: param2
		posn: param3 param4
		setCycle: param5
		show:
	)
)

(procedure (localproc_1788)
	(if local0 (balloon setCel: 3) (proc0_12) (= local0 0))
	(head cel: 0)
	(eyes posn: 140 55 setLoop: 1 setCel: 0)
	(lHand view: 80 setLoop: 6 setCel: 0 posn: 166 80 hide:)
	(lArm view: 80 setLoop: 5 setCel: 0)
	(rHand show: setCycle: Fwd)
	(mouth setCel: 6 setCycle: 0)
	(= local2 0)
	(= global193 0)
)

(procedure (localproc_1821 param1)
	(return
		(switch
			(proc255_0
				(Format @global402 470 46 param1)
				82
				81
				0
				2
				30
				1
				80
				{Haggle Interface}
				81
				{ Yes_}
				1
				81
				{ No_}
				2
			)
			(1 (return 1))
			(2 (return 0))
		)
	)
)

(instance rm470 of Rm
	(properties
		picture 470
		style $0007
	)
	
	(method (init)
		(User canInput: 1 canControl: 1)
		(Load rsVIEW 80)
		(Load rsVIEW 81)
		(Load rsSOUND 13)
		(super init:)
		(gAddToPics add: bones robots)
		(gAddToPics doit:)
		(head init: stopUpd:)
		(eyes init: setScript: EyeBlink)
		(rArm init: stopUpd: setScript: ArmUp)
		(rHand init: setCycle: Fwd setScript: MoveEye)
		(lArm init: stopUpd:)
		(lHand init: stopUpd: hide: setScript: EarWax)
		(mouth init:)
		(balloon init: setCel: 3)
		(if
			(or
				(== (gLongSong state?) 0)
				(== (gLongSong number?) 22)
			)
			(gLongSong number: 13 priority: 3 loop: -1 play:)
		)
		(= local0 0)
		(self setScript: Howdy)
	)
	
	(method (doit &tmp [temp0 30])
		(super doit:)
		(if
		(and (== (balloon cel?) 1) (not gTheNewDialog))
			(localproc_1788)
		)
	)
	
	(method (dispose)
		(if local0 (proc0_12))
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0 [temp1 50])
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evKEYBOARD
				(if (and (== (pEvent message?) KEY_RETURN) local0)
					(localproc_1788)
					(script cue:)
				)
			)
			(evSAID
				(cond 
					((Said 'look[/area,store]') (proc255_0 470 0))
					((Said 'look/counter,box,display,cabinet') (proc255_0 470 1) (= local1 1))
					(
					(Said 'look/head,face,man,blatz,alien,animal,owner') (proc255_0 470 2))
					((Said 'look/mouth') (proc255_0 470 3))
					((Said 'look/eye') (proc255_0 470 4))
					((Said 'look/finger') (proc255_0 470 5))
					((Said 'look/mog,head') (proc255_0 470 6))
					((Said 'look/rock,crystal')
						(if (gEgo has: 0)
							(proc255_0 470 7)
						else
							(proc255_0 470 8)
						)
					)
					(
					(or (Said 'look/deck,ceiling') (Said 'look<up,down')) (proc255_0 470 9))
					((Said 'look/pane') (proc255_0 470 10))
					((Said 'look/partition') (proc255_0 470 11))
					((Said 'look/glass') (proc255_0 470 12))
					((Said 'look/rack') (proc255_0 470 13))
					((Said 'look/shirt') (proc255_0 470 14))
					(
					(Said 'look/shelf,skull,bone,pilot,android,debris,domino') (proc255_0 470 15))
					((Said 'look,read/postcard,card')
						(if (== global600 6)
							(= global600 1)
						else
							(++ global600)
						)
						((ScriptID 471 0) doit:)
					)
					(
						(or
							(Said 'disembark[/area,blatz,store,shop]')
							(Said '/bye')
							(Said 'go<out')
						)
						(global2 setScript: ByeScript)
					)
					((Said 'ask,converse>')
						(cond 
							(
								(or
									(Said '/dog,(scumsoft<soft)')
									(Said '/blatz/dog,(scumsoft<soft)')
								)
								(global2 setScript: ScumScript)
							)
							(
							(or (Said '/pestulon') (Said '/blatz/pestulon')) (global2 setScript: PestScript))
							(else (pEvent claimed: 1) (proc255_0 470 16))
						)
					)
					((Said 'break,beat') (proc255_0 470 17))
					((Said 'rob,attack') (proc255_0 470 18))
					((Said 'kiss') (proc255_0 470 19))
					((Said 'wear,(drop<on)/cap')
						(if (gEgo has: 6)
							(= global130 1)
							(proc255_0 470 20)
						else
							(proc0_9)
						)
					)
					((Said 'remove,(get<off)/cap')
						(cond 
							((not (gEgo has: 6)) (proc0_9))
							(global130 (= global130 0) (proc255_0 470 21))
							(else (proc255_0 470 22))
						)
					)
					(
					(Said 'get/skull,bone,android,pilot,mog,debris,head') (proc255_0 470 23))
					((Said 'get>')
						(if (= temp0 (gInv firstTrue: #saidMe))
							(cond 
								((temp0 ownedBy: 470) (proc255_0 470 23))
								((temp0 ownedBy: gEgo) (proc255_0 470 24))
								(else (proc255_0 470 25))
							)
						)
					)
					(
					(Said 'buy/skull,bone,android,pilot,mog,debris,head') (proc255_0 470 26))
					((Said 'buy/crystal,rock')
						(if (gEgo has: 0)
							(proc255_0 470 27)
						else
							(proc255_0 470 28)
						)
					)
					((Said 'buy/postcard') (proc255_0 470 29))
					((Said 'buy>')
						(if (= temp0 (gInv firstTrue: #saidMe))
							(cond 
								((temp0 ownedBy: 470)
									(if (>= global154 25)
										(proc255_0 470 30)
										(temp0 moveTo: gEgo)
										(gGame changeScore: 5)
										(= global154 (- global154 25))
									else
										(proc255_0 470 31)
									)
								)
								((temp0 ownedBy: gEgo) (proc255_0 470 24))
								(else (proc255_0 470 25))
							)
						)
					)
					(
						(Said
							'give,drop,sell,display,trade/crystal,crystal[<glowing]'
						)
						(if (gEgo has: 0)
							(if (not global103)
								(global2 setScript: Orium)
							else
								(global2 setScript: Orium2)
							)
						else
							(proc255_0 470 32)
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= global193 0)
		(super newRoom: newRoomNumber)
	)
)

(instance Howdy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(localproc_16e2)
				(= local0 (proc255_0 470 33 67 -1 1 70 280 33 600 91))
				(= seconds 15)
			)
			(2
				(localproc_1788)
				(= seconds 8)
			)
			(3
				(client setScript: SalesPitch)
			)
		)
	)
)

(instance PestScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1788)
				(proc0_10)
				(localproc_16e2)
				(= local0 (proc255_0 470 34 67 -1 1 70 280 33 600 91))
				(= local2 0)
				(EarWax changeState: 2)
				(= seconds 15)
			)
			(1
				(localproc_1788)
				(global2 setScript: SalesPitch)
			)
		)
	)
)

(instance ScumScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1788)
				(proc0_10)
				(localproc_16e2)
				(= local0 (proc255_0 470 35 67 -1 1 70 280 33 600 91))
				(= local2 0)
				(EarWax changeState: 2)
				(= seconds 15)
			)
			(1
				(localproc_1788)
				(global2 setScript: SalesPitch)
			)
		)
	)
)

(instance ByeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1788)
				(proc0_10)
				(localproc_16e2)
				(= local0 (proc255_0 470 36 67 -1 1 70 280 33 600 91))
				(= seconds 10)
			)
			(1
				(localproc_1788)
				(proc0_10)
				(gLongSong fade:)
				(global2 newRoom: 43)
			)
		)
	)
)

(instance SalesPitch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(if ((gInv at: 4) ownedBy: 470)
					(localproc_16e2)
					(localproc_1714 1 0 210 93 Fwd)
					(= local0 (proc255_0 470 37 67 -1 1 70 280 33 600 91))
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(2
				(if local0
					(localproc_1788)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(3
				(if ((gInv at: 6) ownedBy: 470)
					(localproc_16e2)
					(localproc_1714 2 1 217 95 0)
					(= local0 (proc255_0 470 38 67 -1 1 70 280 33 600 91))
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(4
				(if local0
					(localproc_1788)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(5
				(if ((gInv at: 5) ownedBy: 470)
					(localproc_16e2)
					(localproc_1714 2 0 215 94 0)
					(= local0 (proc255_0 470 39 67 -1 1 70 280 33 600 91))
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(6
				(if local0
					(localproc_1788)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(7
				(localproc_16e2)
				(= local0 (proc255_0 470 40 67 -1 1 70 280 33 600 91))
				(= seconds 10)
			)
			(8
				(localproc_1788)
				(= seconds 10)
			)
			(9
				(if (== local1 1)
					(localproc_16e2)
					(= local0 (proc255_0 470 41 67 -1 1 70 280 33 600 91))
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(10
				(if (== local1 1)
					(localproc_1788)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(11 (self init:))
		)
	)
)

(instance Orium of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(proc0_2)
				(localproc_1788)
				(= local2 1)
				(= cycles 2)
			)
			(1
				(rock init:)
				(head setCel: 0)
				(eyes setCel: 3 posn: 140 55)
				(mouth setCel: 7)
				(rArm setCel: 2)
				(rHand hide:)
				(lArm setCel: 2)
				(= seconds 4)
			)
			(2
				(rArm setCel: 0)
				(localproc_1788)
				(localproc_16e2)
				(= local0 (proc255_0 470 42 67 -1 1 70 280 33 600 91))
				(= seconds 8)
			)
			(3
				(= global103 1)
				(localproc_1788)
				(switch (localproc_1821 350)
					(0 (= cycles 2))
					(1
						(gEgo get: 8 put: 0)
						(= global154 (+ global154 350))
						(rock dispose:)
						(gGame changeScore: 2)
						(proc0_3)
						(client setScript: SalesPitch)
					)
				)
			)
			(4
				(switch (localproc_1821 400)
					(0 (= cycles 2))
					(1
						(gEgo get: 8 put: 0)
						(= global154 (+ global154 400))
						(rock dispose:)
						(gGame changeScore: 4)
						(proc0_3)
						(client setScript: SalesPitch)
					)
				)
			)
			(5
				(switch (localproc_1821 425)
					(0 (= cycles 2))
					(1
						(gEgo get: 8 put: 0)
						(= global154 (+ global154 425))
						(rock dispose:)
						(gGame changeScore: 8)
						(proc0_3)
						(client setScript: SalesPitch)
					)
				)
			)
			(6
				(localproc_16e2)
				(= local0 (proc255_0 470 43 67 -1 1 70 280 33 600 91))
				(= seconds 8)
			)
			(7
				(localproc_1788)
				(rock dispose:)
				(proc0_3)
				(= local2 0)
				(client setScript: SalesPitch)
			)
		)
	)
)

(instance Orium2 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(proc0_2)
				(localproc_1788)
				(= local2 1)
				(= cycles 2)
			)
			(1
				(rock init:)
				(head setCel: 0)
				(eyes setCel: 0 posn: 140 55)
				(localproc_16e2)
				(= local0 (proc255_0 470 44 67 -1 1 70 280 33 600 91))
				(= seconds 8)
			)
			(2
				(localproc_1788)
				(switch (localproc_1821 100)
					(0 (= cycles 2))
					(1
						(gEgo get: 8 put: 0)
						(= global154 (+ global154 100))
						(rock dispose:)
						(gGame changeScore: 1)
						(proc0_3)
						(client setScript: SalesPitch)
					)
				)
			)
			(3
				(localproc_16e2)
				(= local0 (proc255_0 470 45 67 -1 1 70 280 33 600 91))
				(= seconds 8)
			)
			(4
				(localproc_1788)
				(rock dispose:)
				(proc0_3)
				(= local2 0)
				(client setScript: SalesPitch)
			)
		)
	)
)

(instance EyeBlink of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0 (= seconds (Random 4 7)))
			(1
				(if (!= (= eyesCel (eyes cel?)) 3)
					(eyes loop: 8 cel: 255 setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(2
				(eyes loop: 1 cel: eyesCel)
				(self init:)
			)
		)
	)
)

(instance MoveEye of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0 (= seconds (Random 3 5)))
			(1
				(cond 
					((or local0 (== (eyes cel?) 3)) (self init:))
					((== (eyes cel?) 0) (eyes cel: 1))
					(else (eyes cel: 0))
				)
				(self init:)
			)
		)
	)
)

(instance EarWax of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0 (= seconds (Random 10 25)))
			(1
				(if local2 (self init:) else (= cycles 2))
			)
			(2
				(lArm setCel: 1)
				(lHand show: cycleSpeed: 3 setCycle: End self)
			)
			(3 (lHand setCycle: Beg self))
			(4
				(lHand hide:)
				(lArm setCel: 0)
				(= cycles 1)
			)
			(5 (self init:))
		)
	)
)

(instance ArmUp of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(if local0 (= seconds (Random 4 12)))
			)
			(1
				(if local0
					(rHand hide:)
					(rArm setCel: 1)
					(= seconds 2)
				)
			)
			(2
				(rArm setCel: 0)
				(rHand show:)
				(self init:)
			)
		)
	)
)

(instance head of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 0
			setCel: 0
			setPri: 13
			posn: 141 121
		)
	)
)

(instance eyes of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 1
			setCel: 0
			setPri: 14
			posn: 140 55
		)
	)
)

(instance mouth of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 2
			setCel: 6
			setPri: 14
			cycleSpeed: 0
			posn: 142 101
		)
	)
)

(instance rArm of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 3
			setCel: 0
			setPri: 14
			posn: 98 151
		)
	)
)

(instance rHand of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 4
			setCel: 0
			setPri: 14
			posn: 172 150
		)
	)
)

(instance lArm of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 5
			setCel: 0
			setPri: 14
			posn: 166 100
		)
	)
)

(instance lHand of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 6
			setCel: 0
			setPri: 14
			posn: 166 80
		)
	)
)

(instance balloon of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 81
			setLoop: 0
			setCel: 1
			setPri: 15
			posn: 100 53
		)
	)
)

(instance rock of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 7
			setCel: 0
			setPri: 15
			posn: 155 155
		)
	)
)

(instance bones of PV
	(properties
		y 70
		x 201
		view 74
		priority 3
		signal $4000
	)
)

(instance robots of PV
	(properties
		y 115
		x 208
		view 74
		cel 1
		priority 3
		signal $4000
	)
)
