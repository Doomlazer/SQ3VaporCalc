;;; Sierra Script 1.0 - (do not remove this comment)
(script# 66)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Jump)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm066 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)
(instance rm066 of Rm
	(properties
		picture 66
		horizon 88
		north 60
		east 67
		south 69
	)
	
	(method (init &tmp [temp0 50] theJumpTo)
		(User canInput: 1 canControl: 1)
		(self setRegions: 600)
		(Load rsSOUND 33)
		(if global256
			(Load rsPIC 65)
			(Load rsVIEW 87)
			(Load rsSCRIPT 991)
			(= theJumpTo JumpTo)
		else
			(Load rsVIEW 90)
			(Load rsVIEW 95)
			(Load rsSOUND 78)
		)
		(super init:)
		(if global256
			(global2 drawPic: 65)
		else
			(rock1 init: stopUpd:)
			(rock2 init: stopUpd:)
		)
		(switch gNorth
			(60
				(gEgo
					posn:
						(if (> (gEgo x?) 159) 159 else (gEgo x?))
						(+ (global2 horizon?) 2)
					init:
				)
			)
			(61
				(gEgo posn: 240 (+ (global2 horizon?) 2) init:)
			)
			(67
				(gEgo
					posn:
						317
						(if (< (gEgo y?) (global2 horizon?))
							(+ (global2 horizon?) 2)
						else
							(gEgo y?)
						)
					init:
				)
			)
			(69
				(gEgo posn: 169 187 init:)
				(if (and global256 (not global172))
					(self setScript: MyMy)
				)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)
	
	(method (doit &tmp gEgoOnControl [temp1 50])
		(super doit:)
		(if (== (gEgo view?) 95)
			(if
				(!=
					local5
					(= local4
						(cond 
							(
								(or
									(== (gEgo heading?) 315)
									(== (gEgo heading?) 0)
									(== (gEgo heading?) 45)
								)
								0
							)
							(
							(or (== (gEgo heading?) 90) (== (gEgo heading?) 270)) 2)
							(
								(or
									(== (gEgo heading?) 135)
									(== (gEgo heading?) 180)
									(== (gEgo heading?) 225)
								)
								1
							)
						)
					)
				)
				(switch local4
					(0 (gEgo setLoop: 1))
					(1 (gEgo setLoop: 0))
					(2
						(gEgo setLoop: (if (== local5 0) 1 else 0))
					)
				)
			)
			(= local5 local4)
		)
		(if (not (global2 script?))
			(cond 
				((== (= gEgoOnControl (gEgo onControl:)) 3)
					(gEgo setPri: 3 posn: (gEgo x?) (+ (gEgo y?) 2))
					(= global180 1)
				)
				(
					(or
						(== gEgoOnControl 5)
						(== gEgoOnControl 7)
						(== gEgoOnControl 69)
						(== gEgoOnControl 133)
						(== gEgoOnControl 197)
					)
					(gEgo setPri: 3 posn: (+ (gEgo x?) 6) (gEgo y?))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 9) (== gEgoOnControl 13))
					(gEgo setPri: 5 posn: (gEgo x?) (- (gEgo y?) 2))
					(= global180 1)
				)
				(
					(or
						(== gEgoOnControl 17)
						(== gEgoOnControl 49)
						(== gEgoOnControl 273)
					)
					(gEgo setPri: 7 posn: (gEgo x?) (+ (gEgo y?) 2))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 33) (== gEgoOnControl 161))
					(gEgo setPri: 7 posn: (- (gEgo x?) 12) (gEgo y?))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 257) (== gEgoOnControl 769))
					(gEgo setPri: 5 posn: (- (gEgo x?) 12) (gEgo y?))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 513) (== gEgoOnControl 1537))
					(gEgo setPri: 5 posn: (- (gEgo x?) 6) (gEgo y?))
					(= global180 1)
				)
				(
					(or
						(== gEgoOnControl 2049)
						(== gEgoOnControl 2065)
						(== gEgoOnControl 2053)
					)
					(gEgo setPri: 5 posn: (gEgo x?) (+ (gEgo y?) 2))
					(= global180 1)
				)
				((== gEgoOnControl 1025)
					(gEgo setPri: 3 posn: (- (gEgo x?) 6) (- (gEgo y?) 2))
					(= global180 1)
				)
			)
		)
		(if (and global219 local6) (-- local6))
		(if (== local6 1)
			(= local6 -1)
			(global2 setScript: DeadMeat)
		)
	)
	
	(method (dispose)
		(if global256 (DisposeScript 991))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'leap,jump/canyon[<across,above]')
				(cond 
					((not global256) (proc255_0 66 0))
					((gEgo has: 9) (self setScript: PoleVault))
					(else (proc255_0 66 1))
				)
			)
			((Said 'pole/leap')
				(cond 
					((not global256) (proc255_0 66 0))
					((gEgo has: 9) (self setScript: PoleVault))
					(else (proc255_0 66 1))
				)
			)
			((Said 'use/pole')
				(cond 
					((not global256) (proc255_0 66 2))
					((gEgo has: 9) (self setScript: PoleVault))
					(else (proc0_9))
				)
			)
			((Said 'drop/pole/canyon[<across,above]')
				(cond 
					((not global256) (proc255_0 66 3))
					((gEgo has: 9) (proc255_0 66 4))
					(else (proc0_9))
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== (global2 script?) 0)
			(switch (gEgo edgeHit?)
				(1
					(if (< (gEgo x?) 159)
						(= newRoomNumber 60)
					else
						(= newRoomNumber 61)
					)
				)
				(2 (= newRoomNumber 67))
				(3 (= newRoomNumber 69))
			)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance MyMy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 66 5)
				(= global172 1)
				(global2 setScript: 0)
			)
		)
	)
)

(instance PoleVault of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(gEgo setMotion: MoveTo 229 206 self)
			)
			(1
				(gEgo
					view: 87
					setLoop: 0
					setCel: 0
					setMotion: 0
					setCycle: Fwd
				)
				(proc255_0 66 6)
				(= seconds 2)
			)
			(2
				(gEgo setMotion: MoveTo 195 172 self)
			)
			(3
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(pole init: setCycle: End)
				(gEgo
					setLoop: 3
					setCel: 0
					posn: 177 152
					setCycle: 0
					setMotion: JumpTo 108 143 self
				)
			)
			(5
				(if (gEgo has: 10)
					(proc0_2)
					(kaboom play:)
					(blast init: setCycle: End self)
					(gEgo dispose:)
				else
					(self changeState: 7)
				)
			)
			(6
				(proc255_0 66 7)
				(proc0_17 0 0 16 20)
			)
			(7
				(gEgo
					view: 0
					setLoop: -1
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 98 133 self
				)
			)
			(8
				(pole dispose:)
				(gEgo put: 9)
				(gGame changeScore: 20)
				(proc255_0 66 8)
				(proc0_3)
				(= global159 0)
				(client setScript: 0)
			)
		)
	)
)

(instance DeadMeat of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(kaboom play:)
				(blast init: setCycle: End self)
				(gEgo dispose:)
			)
			(1
				(proc255_0 66 9)
				(proc0_17 0 0 16 20)
			)
		)
	)
)

(instance pole of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 87
			setLoop: 2
			setCel: 0
			setPri: (gEgo priority?)
			posn: 177 172
			ignoreActors:
		)
	)
)

(instance blast of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 87
			setLoop: 4
			setCel: 0
			setPri: (+ (gEgo priority?) 1)
			posn: (gEgo x?) (gEgo y?)
			ignoreActors:
		)
	)
)

(instance rock1 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 1
			setCel: 0
			setPri: 6
			posn: 158 153
			ignoreActors:
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(
				(and
					(== (gEgo onControl: 1) 64)
					(not (global2 script?))
				)
				(cond 
					((not (gEgo mover?)) (if (not local2) (= local2 1) (gEgo setCycle: Fwd)))
					(local2 (= local2 0) (gEgo setCycle: Walk))
				)
				(if (not local0)
					(= local0 1)
					(quake play:)
					(self setCycle: Fwd)
					(gEgo view: 95 setStep: 1 1)
				)
			)
			(local0
				(= local0 0)
				(self setCel: 0 setCycle: 0 stopUpd:)
				(if (and (not local1) (not (global2 script?)))
					(gEgo
						view: 0
						setStep: 3 2
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
					(proc0_10)
					(gEgo setLoop: -1)
				)
			)
		)
	)
)

(instance rock2 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 2
			setCel: 0
			setPri: 6
			posn: 162 170
			ignoreActors:
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(
				(and
					(== (gEgo onControl: 1) 128)
					(not (global2 script?))
				)
				(cond 
					((not (gEgo mover?)) (if (not local3) (= local3 1) (gEgo setCycle: Fwd)))
					(local3 (= local3 0) (gEgo setCycle: Walk))
				)
				(if (not local1)
					(= local1 1)
					(quake play:)
					(self setCycle: Fwd)
					(gEgo view: 95 setStep: 1 1)
				)
				(if (and (gEgo has: 10) (not local6))
					(proc0_2)
					(= local6 2)
				)
			)
			(local1
				(= local1 0)
				(self setCel: 0 setCycle: 0 stopUpd:)
				(if (and (not local0) (not (global2 script?)))
					(gEgo
						view: 0
						setStep: 3 2
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
					(proc0_10)
					(if (not global183) (proc255_0 66 10) (= global183 1))
					(gEgo setLoop: -1)
				)
			)
		)
	)
)

(instance kaboom of Sound
	(properties
		number 33
		priority 3
	)
)

(instance quake of Sound
	(properties
		number 78
		priority 2
	)
)
