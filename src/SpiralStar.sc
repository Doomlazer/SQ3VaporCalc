;;; Sierra Script 1.0 - (do not remove this comment)
(script# 99)
(include sci.sh)
(use Main)
(use Timer)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm99 0
)

(local
	[newSpiralStar 4]
	local4
	local5
	local6
	local7
	local8
	local9
)
(instance rm99 of Rm
	(properties
		picture 99
		style $0000
	)
	
	(method (init)
		(proc0_2)
		(= global159 1)
		(TheMenuBar hide:)
		(SL disable:)
		(= global193 1)
		(Load rsVIEW 801)
		(Load rsVIEW 101)
		(Load rsSOUND 94)
		(Load rsSOUND 93)
		(super init:)
		(proc0_10)
		(= local4 0)
		(while (< local4 4)
			((= [newSpiralStar local4] (SpiralStar new:)) init:)
			(++ local4)
		)
		(gLongSong number: 94 loop: -1 play:)
		(global2 setScript: startShip)
	)
)

(instance startShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (Timer setReal: self 10))
			(1
				(= local7 1)
				(gLongSong number: 93 loop: -1 play:)
				(Timer setReal: self 2)
			)
			(2 (= local6 1))
			(3 (Timer setReal: self 1))
			(4
				(= local8 4)
				(Timer setReal: self 1)
			)
			(5
				(if local8
					(-- state)
					(Timer setCycle: self 1)
				else
					(self cue:)
				)
			)
			(6
				(= local9
					(Display
						{The overwhelming force of the black hole\ndraws your ship in. Helpless to do any-\nthing, you and your passengers strap in\nand hope for the best.}
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
				(Timer setReal: self 10)
			)
			(7
				(= local8 5)
				(Timer setReal: self 1)
			)
			(8
				(if (> local8 1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(self cue:)
				)
			)
			(9
				(Display 99 0 108 local9)
				(global2 newRoom: 98)
			)
		)
	)
)

(class SpiralStar of Prop
	(properties
		y 0
		x 0
		z 0
		heading 0
		yStep 2
		view 101
		loop 0
		cel 0
		priority 13
		underBits 0
		signal $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		cycleSpeed 0
		script 0
		cycler 0
		timer 0
		radius 0
		sel_341 0
		sel_342 0
		sel_343 0
		type $0000
	)
	
	(method (doit)
		(super doit:)
		(if (< radius sel_341)
			(self sel_344:)
		else
			(if (and local8 (> radius 187))
				(= radius (+ radius sel_341))
			)
			(= radius (- radius sel_341))
			(= sel_342 (mod (+ sel_342 sel_343 360) 360))
			(self
				posn: (+ 160 (CosMult sel_342 radius)) (+ 95 (SinMult sel_342 radius))
			)
			(switch type
				(0
					(if (and (< radius 50) (< cel (self lastCel:)))
						(++ cel)
						(self sel_341: 8)
					)
				)
				(1
					(if (and (< radius 100) (< cel (self lastCel:)))
						(++ cel)
					)
				)
				(2
					(if (and (< radius 80) (< cel (self lastCel:)))
						(++ cel)
					)
				)
			)
			(self stopUpd:)
		)
	)
	
	(method (sel_344)
		(switch type
			(0)
			(1 (= local5 0))
			(2
				(= local7 0)
				(startShip cue:)
			)
		)
		(if local6
			(= local6 0)
			(self
				type: 2
				view: 801
				setPri: 15
				setLoop: 0
				setCel: 0
				radius: 120
				sel_341: 7
				sel_342: 125
				sel_343: -5
			)
		else
			(if
			(and (not local5) (not local7) (== 1 (Random 1 2)))
				(= local5 1)
				(self
					type: 1
					view: 101
					setPri: 14
					setLoop: 1
					setCel: 0
					radius: (+ 187 local8)
					sel_341: 16
					sel_342: (* (- (Random 1 72) 1) 5)
					sel_343: -5
				)
			else
				(self
					type: 0
					view: 101
					setPri: 13
					setLoop: 0
					setCel: 0
					radius: (+ 187 local8)
					sel_341: (Random 5 8)
					sel_342: (* (- (Random 1 72) 1) 5)
					sel_343: (* (Random 1 2) 5)
				)
			)
			(if local8 (-- local8))
		)
		(self doit:)
	)
)
