;;; Sierra Script 1.0 - (do not remove this comment)
(script# 6)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Chase)
(use Avoid)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm006 0
)

(local
	local0
)
(instance rm006 of Rm
	(properties
		picture 6
		style $0000
		horizon 10
	)
	
	(method (init &tmp [temp0 50])
		(self setLocales: 700)
		(Load rsVIEW 7)
		(Load rsVIEW 15)
		(Load rsVIEW 18)
		(Load rsVIEW 751)
		(Load rsVIEW 192)
		(Load rsVIEW 0)
		(Load rsSOUND 77)
		(gEgo view: 0 setStep: -1 1)
		(super init:)
		(gEgo
			setAvoider: (Avoid new:)
			x: (if (== gNorth 5) -6 else 326)
			y: 147
			setMotion: MoveTo (if (== gNorth 5) 400 else -400) 147
			init:
		)
		(User prevDir: (if (== gNorth 5) 3 else 7))
		(shadow init:)
		(if (proc0_13 1) (wire init:))
	)
	
	(method (doit)
		(cond 
			(
				(and
					(gEgo has: 3)
					(gEgo inRect: 160 146 171 150)
					(not global131)
					(not (gCast contains: rat))
				)
				(rat init:)
			)
			((< (gEgo x?) -6) (global2 newRoom: 5))
			((> (gEgo x?) 326) (global2 newRoom: (if global157 27 else 7)))
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look>')
						(cond 
							(
								(or
									(Said '[<up,above,at]/ceiling')
									(Said '<up,above[/ceiling]')
								)
								(proc255_0 6 0)
							)
							((Said '/partition') (proc255_0 6 1))
							((Said '/door,console[<absent]') (proc255_0 6 2))
							((Said '<below/console[<absent]') (proc255_0 6 3))
							(
								(or
									(Said '[<down,below,at]/dirt,deck')
									(Said '<down,below[/dirt,deck]')
								)
								(proc255_0 6 4)
							)
							(
							(Said '[<around,at,in][/area,tube,cave,pit,stage,!*]') (proc255_0 6 5))
							((Said '/cable<left,fine') (if (proc0_13 1) (proc255_0 6 6)))
							((Said '/cable[<bad,jagged,all]') (if (proc0_13 1) (proc255_0 6 7) else (proc255_0 6 8)))
							((Said '[<in,at,through,in]/grate') (proc255_0 6 9))
							((Said '/mice,animal')
								(cond 
									((gCast contains: rat) (proc255_0 6 10))
									(global131 (proc255_0 6 11))
									(else (proc255_0 6 12))
								)
							)
							((Said '[<in,in,through,at]/cavity') (proc255_0 6 13))
							((Said '/conduit') (proc255_0 6 14))
						)
					)
					((Said 'climb/craft,pit,craft,side') (proc255_0 6 15))
					((Said 'get,(drag[<on])/cable')
						(if (proc0_13 1)
							(if (gEgo inRect: 64 147 85 149)
								(self setScript: wireScript)
							else
								(proc255_0 6 16)
							)
						else
							(proc255_0 6 17)
						)
					)
					((Said 'get/conduit') (proc255_0 6 18))
					(
						(Said
							'get,climb,crawl,conceal[<in,in,through,below]/grate'
						)
						(proc255_0 6 19)
					)
					(
						(Said
							'press,hoist,manipulate,open,get,remove/console,(iron[<mushroom])'
						)
						(proc255_0 6 20)
					)
				)
			)
			(evMOUSEBUTTON
				(if (== (User controls?) 0) (return))
				(gEgo
					setMotion:
						MoveTo
						(cond 
							((< (pEvent x?) 30) -30)
							((> (pEvent x?) 295) 330)
							(else (pEvent x?))
						)
						(gEgo y?)
				)
				(pEvent claimed: 1)
			)
			(evJOYSTICK
				(if (== (User controls?) 0) (return))
				(switch (pEvent message?)
					(JOY_UP
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_DOWN
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_UPLEFT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_UPRIGHT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_DOWNRIGHT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
					(JOY_DOWNLEFT
						(gEgo setMotion: 0)
						(pEvent claimed: 1)
						(return)
					)
				)
			)
		)
		(super handleEvent: pEvent)
	)
)

(instance wireScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 192
					loop: (if (< (gEgo x?) (wire x?)) 1 else 0)
					cel: 0
					setMotion: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1 (= cycles 5))
			(2
				(wire dispose:)
				(gEgo get: 1)
				(= cycles 2)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(gEgo view: 0 cycleSpeed: 0 setCycle: Walk)
				(= cycles 2)
				(gGame changeScore: 5)
			)
			(5
				(proc255_0 6 21)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance shadowScript of Script
	(properties)
	
	(method (doit)
		(if
			(or
				(gEgo inRect: -9 145 56 150)
				(gEgo inRect: 281 145 329 150)
			)
			(shadow loop: (gEgo loop?) cel: (gEgo cel?))
			(if (gEgo inRect: -9 145 56 150)
				(shadow view: 7)
			else
				(shadow view: 18)
			)
			(shadow
				posn:
					(if (gEgo inRect: -9 145 56 150)
						(+ (gEgo x?) 12)
					else
						(- (gEgo x?) 12)
					)
					147
			)
			(if (!= local0 1) (shadow show:) (= local0 1))
		else
			(shadow hide:)
			(= local0 0)
		)
		(super doit:)
	)
)

(instance ratScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(rat setMotion: MoveTo 197 (+ (gEgo y?) 4) self)
				(= global131 1)
			)
			(1
				(User canInput: 0)
				(rat
					setStep: -1 5
					setLoop: -1
					loop: 1
					setCycle: Walk
					setMotion: Chase gEgo 4 self
				)
			)
			(2
				(proc0_2)
				(rumbleSound play:)
				(gEgo setMotion: 0)
				(rat
					setStep: 1 1
					posn: (gEgo x?) (- (gEgo y?) 4)
					setLoop: 3
					setCycle: Fwd
					setPri: 14
				)
				(= seconds 2)
			)
			(3 (biff init:) (= seconds 2))
			(4
				(biff setCel: 1 posn: (+ (rat x?) 17) (- (rat y?) 12))
				(= seconds 2)
				(if (gEgo has: 3)
					(proc0_14 3 15)
					(gGame changeScore: -15)
				)
				(if (gEgo has: 1)
					(proc0_14 1 15)
					(gGame changeScore: -5)
				)
			)
			(5
				(biff dispose:)
				(= seconds 2)
			)
			(6
				(gEgo view: 751 loop: 0)
				(rat
					setLoop: 0
					x: (+ (gEgo x?) 13)
					y: (+ (gEgo y?) 4)
					setStep: 10
					setMotion: MoveTo 310 (+ (gEgo y?) 4) self
				)
				(rumbleSound stop:)
			)
			(7
				(rat dispose:)
				(proc0_10)
				(proc0_3)
				(gEgo view: 0 setDirection: 0)
				(proc0_10)
				(proc255_0 6 22)
			)
		)
	)
)

(instance rat of Act
	(properties
		view 15
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			illegalBits: 0
			setLoop: 2
			posn: 197 78
			setStep: 5 15
			setMotion: MoveTo 197 (+ (gEgo y?) 4) self
			setScript: ratScript
		)
	)
)

(instance wire of View
	(properties
		view 192
		loop 2
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1 posn: 77 124)
	)
)

(instance shadow of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: (if (== gNorth 5) 7 else 18)
			setLoop: (if (== gNorth 5) 0 else 1)
			ignoreActors: 1
			x: (if (== gNorth 5) 6 else 314)
			y: 147
			setPri: 4
			setScript: shadowScript
			ignoreActors: 1
		)
	)
)

(instance biff of View
	(properties
		view 15
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 4
			setCel: 0
			setPri: 15
			ignoreActors: 1
			posn: (- (rat x?) 15) (- (rat y?) 22)
		)
	)
)

(instance rumbleSound of Sound
	(properties
		number 77
		priority 5
		loop -1
	)
)
