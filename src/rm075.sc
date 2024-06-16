;;; Sierra Script 1.0 - (do not remove this comment)
(script# 75)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Avoid)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm075 0
)

(local
	local0
	local1
	local2
	local3
	gEgoX
	gEgoY
)
(instance rm075 of Rm
	(properties
		picture 75
	)
	
	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(self setRegions: 600)
		(Load rsVIEW 94)
		(Load rsVIEW 99)
		(Load rsVIEW 100)
		(Load rsSOUND 33)
		(Load rsSOUND 45)
		(super init:)
		(gLongSong number: 50 loop: -1 priority: 0 play:)
		(global2 setScript: UpLadder)
	)
	
	(method (doit &tmp gEgoOnControl [temp1 50])
		(super doit:)
		(if local0 (self newRoom: 74))
		(if
			(and
				(or
					(== (gEgo onControl:) 8)
					(== (gEgo onControl:) 24)
				)
				(not (global2 script?))
				(== (gEgo x?) gEgoX)
				(== (gEgo y?) gEgoY)
				(not local1)
			)
			(= local1 1)
			(gEgo setMotion: MoveTo (+ (gEgo x?) 20) 229)
		)
		(= gEgoX (gEgo x?))
		(= gEgoY (gEgo y?))
		(if (== (global2 script?) 0)
			(= gEgoOnControl (gEgo onControl:))
			(self
				setScript:
					(cond 
						((== gEgoOnControl 4) walkGreen)
						((== gEgoOnControl 8) walkCyan)
						((== gEgoOnControl 16) fallRed)
						(
						(or (== gEgoOnControl 2) (== gEgoOnControl 66)) fallBlue)
						(
						(or (== gEgoOnControl 40) (== gEgoOnControl 56)) TopLadder)
						(else 0)
					)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '[/area,around]') (if global256 (proc255_0 75 0) else (proc255_0 75 1)))
					((Said '/down,cavity,edge')
						(if (== (gEgo onControl:) 64)
							(if global256 (proc255_0 75 2) else (proc255_0 75 3))
						else
							(proc255_0 75 4)
						)
					)
					((Said '/moon,pestulon') (proc255_0 75 5))
					((Said '/ladder') (proc255_0 75 6))
					((Said '/device,building,generator')
						(cond 
							((not global256) (if global170 (proc255_0 75 7) else (proc255_0 75 8)))
							(global170 (proc255_0 75 9))
							(else (proc255_0 75 10))
						)
					)
					((Said '/beam')
						(if (not global256)
							(if global170 (proc255_0 75 11) else (proc255_0 75 12))
						else
							(proc255_0 75 13)
						)
					)
					((Said '/lava') (proc255_0 75 14))
				)
			)
			((Said 'jump,enter,go/generator,cavity') (proc255_0 75 15))
			((Said '(climb[<up]),ladder') (proc255_0 75 16))
			((Said 'down,descend,(climb[<down])[/ladder]')
				(if (gEgo inRect: 157 98 183 106)
					(global2 setScript: DownLadder)
				else
					(proc255_0 75 17)
				)
			)
			((Said 'throw,drop/detonator,bomb')
				(cond 
					(global256 (proc0_6))
					((not (gEgo has: 10)) (proc255_0 75 18))
					(
						(or
							(== (gEgo onControl:) 64)
							(== (gEgo onControl:) 66)
						)
						(global2 setScript: DropBomb)
					)
					(else (proc255_0 75 19))
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not script)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance UpLadder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(gEgo
					illegalBits: 0
					posn: 313 219
					view: 99
					setStep: 3 2
					setLoop: 0
					setMotion: MoveTo 173 113 self
					init:
				)
			)
			(1
				(gEgo
					view: 0
					illegalBits: -32768
					posn: 169 105
					setStep: 3 2
					setLoop: -1
				)
				(= cycles 2)
			)
			(2
				(gEgo loop: 1)
				(proc0_3)
				(= global159 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance TopLadder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(gEgo illegalBits: 0 setMotion: MoveTo 173 113 self)
			)
			(1
				(gEgo
					view: 0
					illegalBits: -32768
					posn: 169 105
					setStep: 3 2
					setLoop: -1
				)
				(= cycles 2)
			)
			(2
				(gEgo loop: 1)
				(= local2 0)
				(= local3 1)
				(proc0_3)
				(= global159 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance DownLadder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(gEgo illegalBits: 0 setMotion: MoveTo 169 105 self)
			)
			(1
				(gEgo
					posn: 173 113
					view: 99
					setLoop: 0
					setMotion: MoveTo 313 219 self
				)
			)
			(2
				(= local0 1)
				(global2 setScript: 0)
				(= global159 0)
				(proc0_3)
			)
		)
	)
)

(instance walkCyan of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local2)
					(= local2 1)
					(= local3 0)
					(= local1 0)
					(gEgo view: 99 setAvoider: Avoid setLoop: 0)
				)
				(global2 setScript: 0)
			)
		)
	)
)

(instance walkGreen of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local3)
					(= local3 1)
					(= local2 0)
					(gEgo
						view: 0
						setAvoider: 0
						loop:
							(switch (gEgo heading?)
								(0 3)
								(45 0)
								(90 0)
								(135 0)
								(180 2)
								(225 1)
								(270 1)
								(315 1)
							)
					)
				)
				(proc0_10)
				(gEgo setLoop: -1)
				(global2 setScript: 0)
			)
		)
	)
)

(instance fallRed of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(not (gEgo mover?))
				(== (falling prevSignal?) -1)
			)
			(self changeState: 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(falling play:)
				(gEgo
					view: 99
					setLoop: 1
					setStep: 6 12
					setCycle: 0
					posn: (gEgo x?) (gEgo y?)
					illegalBits: 0
				)
				(if (> (gEgo x?) 180)
					(gEgo setStep: 12 12 setCel: 1 setMotion: MoveTo 340 189)
				else
					(gEgo setCel: 0 setMotion: MoveTo (+ (gEgo x?) 20) 229)
				)
				(ohnoScript changeState: 0)
			)
			(1 (proc0_17 0 0 0 1))
		)
	)
)

(instance fallBlue of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== (falling prevSignal?) -1)
			(self changeState: 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(falling play:)
				(gEgo
					setLoop:
					setCel:
					setStep: 6 12
					setCycle: 0
					setPri: 2
					illegalBits: 0
				)
				(proc0_10)
				(gEgo setMotion: MoveTo (gEgo x?) 229)
				(ohnoScript changeState: 0)
			)
			(1 (proc0_17 0 0 0 1))
		)
	)
)

(instance ohnoScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(OhNo init: setCycle: End self)
			)
			(1 (OhNo dispose:))
		)
	)
)

(instance DropBomb of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(gEgo view: 100 setLoop: 0 setCel: 0)
				(bomb init:)
				(gEgo put: (= cycles 10))
			)
			(1
				(gEgo setCel: 1)
				(bomb setMotion: MoveTo (bomb x?) 150 self)
			)
			(2
				(gEgo setCel: 2)
				(bomb dispose:)
				(blowUp play:)
				(flash init: setCycle: End self)
			)
			(3
				(ShakeScreen 20 3)
				(blowUp play:)
				(flash setCycle: End self)
			)
			(4
				(ShakeScreen 20 3)
				(gLongSong stop:)
				(proc0_10)
				(gLongSong number: 71 loop: -1 priority: 0 play:)
				(if global170 (proc255_0 75 20) else (proc255_0 75 21))
				(gEgo view: 0 setLoop: -1 setCel: -1 cel: 0 loop: 1)
				(gGame changeScore: 20)
				(= global256 1)
				(= global257 300)
				(proc0_3)
				(= global159 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance OhNo of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 94
			setLoop: 0
			setCel: 0
			cycleSpeed: 1
			setPri: (gEgo priority?)
			posn: (gEgo x?) (- (gEgo y?) 50)
			ignoreActors: 1
		)
	)
)

(instance bomb of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 100
			setLoop: 0
			setCel: 3
			setPri: 2
			posn: (- (gEgo x?) 10) (- (gEgo y?) 21)
			setStep: 1 4
			ignoreControl: 1
			ignoreActors: 1
			illegalBits: 0
		)
	)
)

(instance flash of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 100
			setLoop: 1
			setCel: 0
			setPri: 3
			posn: 82 79
			ignoreActors: 1
		)
	)
)

(instance falling of Sound
	(properties
		number 45
		priority 1
	)
)

(instance blowUp of Sound
	(properties
		number 33
		priority 1
	)
)
