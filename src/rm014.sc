;;; Sierra Script 1.0 - (do not remove this comment)
(script# 14)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm014 0
)

(local
	local0
	local1
	local2
	local3
)
(procedure (localproc_2008)
	(pilot loop: 1 setPri: 15 posn: 150 189 stopUpd:)
	(= global203 0)
)

(procedure (localproc_2029)
	(pilot loop: 0 setPri: 10 posn: 161 114 stopUpd:)
	(= global203 1)
)

(instance rm014 of Rm
	(properties
		picture 14
		style $0000
	)
	
	(method (init &tmp [temp0 150])
		(if
		(not (if (and (== global176 5) global179) global181))
			(if
				(not
					(if (and (== global206 2) (== global207 2))
						(== gNorth 17)
					)
				)
				(self setRegions: 701)
			)
		)
		(Load rsVIEW 31)
		(Load rsVIEW 28)
		(Load rsVIEW 65)
		(Load rsSOUND 31)
		(Load rsSOUND 33)
		(Load rsSOUND 59)
		(Load rsSOUND 83)
		(pilot init:)
		(super init:)
		(if (!= gNorth 31) (TheMenuBar draw:) (SL enable:))
		(switch gNorth
			(2
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_2029)
			)
			(8
				(wallA init: setLoop: 1 setCel: 0)
				(wallB init: setLoop: 1 setCel: 1)
				(wallC init: setLoop: 1 setCel: 2)
				(localproc_2008)
			)
			(16
				(localproc_2008)
				(cond 
					((== global210 0)
						(wallA init: setLoop: 1 setCel: 0)
						(wallB init: setLoop: 1 setCel: 1)
						(wallC init: setLoop: 1 setCel: 2)
					)
					(
						(or
							(== global210 1)
							(== global210 2)
							(== global210 3)
							(== global210 7)
							(== global210 4)
						)
						(wallA init: setLoop: 4 setCel: 0)
					)
					((== global210 5) (wallA init: setLoop: 2 stopUpd:))
					((== global210 6) (wallA init: setLoop: 3 stopUpd:))
					((== global210 8) (wallA init: setLoop: 5 stopUpd:))
				)
				(if (== global209 6)
					(Load rsSOUND 69)
					(TheMenuBar hide:)
					(SL disable:)
					(lp1 init:)
					(lp2 init:)
					(lp3 init:)
					(lp4 init:)
					(gLongSong number: 69 loop: -1 play:)
				)
			)
			(17
				(localproc_2029)
				(cond 
					((== global210 0)
						(wallA init: setLoop: 1 setCel: 0)
						(wallB init: setLoop: 1 setCel: 1)
						(wallC init: setLoop: 1 setCel: 2)
					)
					(
						(or
							(== global210 1)
							(== global210 2)
							(== global210 3)
							(== global210 7)
							(== global210 4)
						)
						(wallA init: setLoop: 4 setCel: 0)
					)
					((== global210 5) (wallA init: setLoop: 2 stopUpd:))
					((== global210 6) (wallA init: setLoop: 3 stopUpd:))
					((== global210 8) (wallA init: setLoop: 5 stopUpd:))
				)
				(if
					(and
						(== global210 1)
						(or (== global209 2) (== global209 3))
					)
					(if
					(not (if (== global213 69) (== global214 82)))
						(if
						(not (if (== global213 82) (== global214 69)))
							(if
								(and
									(not (if (and (== global176 5) global179) global181))
									(not global178)
								)
								(proc0_10)
								(if (== global209 2)
									(proc255_0 14 0)
								else
									(proc255_0 14 1)
								)
							)
						)
					)
				)
				(if (== global209 6)
					(Load rsSOUND 69)
					(TheMenuBar hide:)
					(SL disable:)
					(lp1 init:)
					(lp2 init:)
					(lp3 init:)
					(lp4 init:)
					(localproc_2029)
					(gLongSong number: 69 loop: -1 play:)
				)
			)
			(20
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_2029)
				(= global210 1)
				(= global207 1)
			)
			(21
				(localproc_2029)
				(cond 
					((== global210 5) (wallA init: setLoop: 2 stopUpd:) (= local3 {Ortega}))
					((== global210 6) (wallA init: setLoop: 3 stopUpd:) (= local3 {Phleebhut}))
					((== global210 8) (wallA init: setLoop: 5 stopUpd:) (= local3 {Pestulon}))
				)
				(proc0_10)
				(gLongSong stop:)
				(powerDown play:)
				(= global208 0)
				(ShakeScreen 10 3)
				(proc255_0 (Format @temp0 14 2 local3))
			)
			(28
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_2029)
				(= global158 1)
				(= global210 2)
			)
			(31
				(if (== global209 6)
					(Load rsSOUND 69)
					(TheMenuBar hide:)
					(SL disable:)
					(lp1 init:)
					(lp2 init:)
					(lp3 init:)
					(lp4 init:)
					(localproc_2029)
					(gLongSong number: 69 loop: -1 play:)
				else
					(localproc_2029)
					(wallA init: setLoop: 4 setCel: 0)
					(proc0_10)
					(if (== global209 2)
						(proc255_0 14 0)
					else
						(proc255_0 14 1)
					)
				)
			)
			(49
				(wallA init: setLoop: 3 stopUpd:)
				(localproc_2008)
				(gLongSong fade:)
				(= local1 1)
				(= global210 6)
				(= global206 0)
				(self setScript: rampScript)
			)
			(62
				(wallA init: setLoop: 2 stopUpd:)
				(localproc_2008)
				(gLongSong fade:)
				(= local1 1)
				(= global210 5)
				(= global206 0)
				(self setScript: rampScript)
			)
			(80
				(wallA init: setLoop: 5 stopUpd:)
				(localproc_2008)
				(gLongSong fade:)
				(= local1 1)
				(= global210 8)
				(= global206 0)
				(self setScript: rampScript)
			)
			(94
				(= global178 1)
				(self setScript: (ScriptID 22 0))
				(= global102 22)
				(wallA init: setLoop: 4 setCel: 0)
				(localproc_2029)
				(proc255_0 14 3)
				(= global175 60)
				(= global218 1)
				(= global210 7)
				(= global206 3)
				(= global179 1)
				(= global208 2)
			)
		)
		(if (and global178 (!= gNorth 94))
			(if (and (== global176 5) global179 global181)
				(self setScript: (ScriptID 24 0))
				(= global102 24)
			else
				(self setScript: (ScriptID 23 0))
				(= global102 23)
			)
		)
		(if (or (not (proc0_13 3)) (not (proc0_13 1)))
			(floorPanel init:)
		)
		(if
			(and
				(or (== global206 0) (== global206 3))
				(!= global102 24)
			)
			(proc0_3)
		)
		(= global100 0)
		(= global159 0)
	)
	
	(method (doit)
		(if (and global167 (not script))
			(self setScript: arrivalScript)
		)
		(if global258 (self newRoom: 99))
		(super doit:)
	)
	
	(method (dispose)
		(if local0 (local0 dispose:))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evMOUSEBUTTON
				(cond 
					((and (== global203 0) (not global155))
						(cond 
							(
								(and
									(<= 143 (pEvent x?))
									(<= (pEvent x?) 180)
									(<= 63 (pEvent y?))
									(<= (pEvent y?) 117)
								)
								(pEvent claimed: 1)
								(localproc_2029)
							)
							(
								(and
									(<= 263 (pEvent x?))
									(<= (pEvent x?) 319)
									(<= 59 (pEvent y?))
									(<= (pEvent y?) 142)
								)
								(pEvent claimed: 1)
								(proc0_12)
								(global2 newRoom: 16)
							)
							(
								(and
									(== global210 0)
									(<= 105 (pEvent x?))
									(<= (pEvent x?) 215)
									(<= 0 (pEvent y?))
									(<= (pEvent y?) 17)
								)
								(pEvent claimed: 1)
								(global2 newRoom: 8)
							)
							(
								(and
									(<= 276 (pEvent x?))
									(<= (pEvent x?) 301)
									(<= 160 (pEvent y?))
									(<= (pEvent y?) 177)
								)
								(pEvent claimed: 1)
								(proc0_12)
								(if (== global203 0)
									(cond 
										(
										(or (== global210 5) (== global210 6) (== global210 8)) (self setScript: rampScript))
										((== global210 0) (proc255_0 14 4) (global2 newRoom: 8))
										(else (proc255_0 14 5))
									)
								else
									(proc255_0 14 6)
								)
							)
						)
					)
					(
						(and
							(== global203 1)
							(not global155)
							(not (== global209 6))
							(<= 105 (pEvent x?))
							(<= (pEvent x?) 215)
							(<= 131 (pEvent y?))
							(<= (pEvent y?) 189)
						)
						(pEvent claimed: 1)
						(localproc_2008)
					)
				)
			)
			(evSAID
				(cond 
					((Said '/motivator') (proc255_0 14 7))
					(
						(Said
							'press,disembark,disembark,open,(get<out)[/ramp,door,button,craft]'
						)
						(if (== global203 0)
							(cond 
								(
								(or (== global210 5) (== global210 6) (== global210 8)) (self setScript: rampScript))
								((== global210 0) (proc255_0 14 4) (global2 newRoom: 8))
								(else (proc255_0 14 5))
							)
						else
							(proc255_0 14 6)
						)
					)
					((Said 'close/door,door,ramp') (proc255_0 14 8))
					(
						(or
							(Said '(turn<on),use,begin,fly/engine,craft')
							(Said 'launch,land,park[/craft]')
							(Said 'shoot[/gun]')
						)
						(proc255_0 14 9)
					)
					(
					(Said 'enter,go,(sit[<down,in]),get/chair<passenger')
						(cond 
							((== global203 1) (proc255_0 14 10))
							(global178 (proc255_0 14 11))
							(else (proc255_0 14 12))
						)
					)
					(
						(or
							(Said 'sit[<down]')
							(Said 'enter,go,(sit[<down,in]),get/chair,cabin')
						)
						(if (== global203 1)
							(proc255_0 14 10)
						else
							(localproc_2029)
						)
					)
					(
						(or
							(Said '(get<up),stand[<up]')
							(Said 'disembark/chair,cabin')
						)
						(cond 
							((== global203 0) (proc255_0 14 13))
							((== global209 6) (proc255_0 14 14))
							(else (localproc_2008))
						)
					)
					((Said 'use,wear,drop[<on]/panties')
						(cond 
							((not (gEgo has: 5)) (proc255_0 14 15))
							(global182 (proc255_0 14 16))
							((== global203 1) (proc255_0 14 17))
							(else
								(proc255_0 14 18)
								(gGame changeScore: 10)
								(= global182 1)
							)
						)
					)
					((Said 'remove,get[<off]/panties')
						(cond 
							((not (gEgo has: 5)) (proc255_0 14 15))
							(global182 (proc255_0 14 19))
							(else (proc255_0 14 20))
						)
					)
					((Said 'explore/cushion,chair')
						(cond 
							((== global203 0) (proc255_0 14 21))
							((not global150)
								(proc255_0 14 22)
								(gGame changeScore: 10)
								(= global154 (+ global154 7))
								(gEgo get: 8)
								(= global150 1)
							)
							(else (proc255_0 14 23))
						)
					)
					(
						(Said
							'remove,hoist,open,get/tile,compartment,(console[<video])'
						)
						(if (!= global136 4)
							(proc255_0 14 24)
						else
							(proc255_0 14 25)
						)
					)
					(
					(Said 'close/tile,compartment,deck,(console[<video])')
						(if (!= global136 4)
							(proc255_0 14 26)
						else
							(proc255_0 14 27)
						)
					)
					((Said 'converse/man,man') (if global178 (proc255_0 14 28) else (proc255_0 14 29)))
					((Said 'look>')
						(cond 
							((Said '/cavity,compartment')
								(switch global136
									(4 (proc255_0 14 27))
									(3 (proc255_0 14 30))
									(2 (proc255_0 14 31))
									(else  (proc255_0 14 32))
								)
							)
							((Said '/tile')
								(if (!= global136 4)
									(proc255_0 14 33)
								else
									(proc255_0 14 34)
								)
							)
							((or (Said '/deck') (Said '<down'))
								(if (!= global136 4)
									(proc255_0 14 35)
								else
									(proc255_0 14 36)
								)
							)
							((Said '/console')
								(cond 
									((== global203 1) (proc255_0 14 37))
									((<= global136 1) (proc255_0 14 38))
									((== global136 3) (proc255_0 14 30))
									((== global136 2) (proc255_0 14 31))
									(else (proc255_0 14 39))
								)
							)
							((Said '/comp<access')
								(cond 
									((== global209 6) (proc255_0 14 40))
									((== global203 0) (global2 newRoom: 16))
									(else (proc255_0 14 41))
								)
							)
							(
								(or
									(Said '/(comp[<scum]),control')
									(Said '/comp[<comp]')
								)
								(cond 
									((== global209 6) (proc255_0 14 40))
									((== global203 0) (proc0_12) (global2 newRoom: 16))
									((and (proc0_13 3) (proc0_13 1)) (proc0_12) (global2 newRoom: 17))
									(else (proc255_0 14 42))
								)
							)
							((Said '/partition') (proc255_0 14 43))
							((Said '/man,prize,scott') (if global178 (proc255_0 14 44) else (proc255_0 14 45)))
							((Said '/cushion')
								(if (== global203 0)
									(proc255_0 14 21)
								else
									(proc255_0 14 46)
								)
							)
							((Said '/cabin')
								(if (== global203 1)
									(proc255_0 14 47)
								else
									(proc255_0 14 48)
								)
							)
							((Said '/pane')
								(switch global210
									(0 (proc255_0 14 49))
									(1
										(if (== global209 6)
											(proc255_0 14 50)
										else
											(proc255_0 14 51)
										)
									)
									(2 (proc255_0 14 52))
									(3 (proc255_0 14 53))
									(4 (proc255_0 14 54))
									(7 (proc255_0 14 55))
									(5 (proc255_0 14 56))
									(6 (proc255_0 14 57))
									(8 (proc255_0 14 58))
									(else  (proc255_0 14 59))
								)
							)
							((Said '/chair<passenger') (if global178 (proc255_0 14 11) else (proc255_0 14 12)))
							((Said '/chair')
								(cond 
									((== global203 1) (proc255_0 14 60))
									(global178 (proc255_0 14 11))
									(else (proc255_0 14 12))
								)
							)
							((Said '/star,eva')
								(if (== global210 1)
									(proc255_0 14 61)
								else
									(proc255_0 14 62)
								)
							)
							((or (Said '/ceiling') (Said '<up'))
								(cond 
									((== global203 0) (proc255_0 14 63))
									((== global210 0) (proc255_0 14 64))
									(else (proc255_0 14 65))
								)
							)
							((Said '/ramp') (proc255_0 14 66))
							((Said '/door') (proc255_0 14 67))
							((Said '/button') (proc255_0 14 68))
							((or (Said '/hal[<cable]') (Said 'cable'))
								(if (gCast contains: floorPanel)
									(proc255_0 14 69)
								else
									(proc255_0 14 70)
								)
							)
							((Said '[<around,at,in][/area,craft]')
								(cond 
									((== global203 1) (proc255_0 14 47))
									((not global169) (= global169 1) (proc255_0 14 71))
									(else (proc255_0 14 72))
								)
							)
						)
					)
					(
						(or
							(Said 'go,look,(turn<on)/(comp[<scum]),control')
							(Said '/comp')
						)
						(cond 
							((== global203 0) (proc0_12) (global2 newRoom: 16))
							((and (proc0_13 3) (proc0_13 1)) (proc0_12) (global2 newRoom: 17))
							(else (proc255_0 14 42))
						)
					)
					(
						(Said
							'replace,use,fix,place,insert,drop,afix,cable/[/cavity,compartment,deck,console,generator,cable]>'
						)
						(cond 
							((Said '/generator')
								(cond 
									((proc0_13 3) (proc255_0 14 73))
									((not (gEgo has: 3)) (proc0_9))
									((== global203 0) (self setScript: reactorScript))
									(else (proc255_0 14 74))
								)
							)
							(
							(or (Said '/cable') (Said '<cable') (Said 'cable<use'))
								(cond 
									((proc0_13 1) (proc255_0 14 73))
									((not (gEgo has: 1)) (proc0_9))
									((== global203 0) (self setScript: wireScript))
									(else (proc255_0 14 74))
								)
							)
							((or (Said '/crystal') (Said '<crystal'))
								(if (not (gEgo has: 0))
									(proc0_9)
								else
									(proc255_0 14 75)
								)
							)
						)
					)
					((Said 'turn,switch[<on]/generator') (proc255_0 14 76))
					((Said 'get/generator')
						(cond 
							((gEgo has: 3) (proc255_0 14 77))
							((proc0_13 3 14) (proc255_0 14 78))
							(else (proc255_0 14 79))
						)
					)
					((Said 'get/cable')
						(if (gEgo has: 1)
							(proc255_0 14 77)
						else
							(proc255_0 14 78)
						)
					)
					((Said 'drop,use,afix[<on]/belt')
						(if (== global203 1)
							(proc255_0 14 80)
						else
							(proc255_0 14 81)
						)
					)
					((Said 'open/console[<video]')
						(if (!= global136 4)
							(proc255_0 14 82)
						else
							(proc255_0 14 83)
						)
					)
					((Said 'close,replace/console[<video]')
						(if (!= global136 4)
							(proc255_0 14 84)
						else
							(proc255_0 14 8)
						)
					)
					((Said 'go/compartment,cavity') (proc255_0 14 85))
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if global102
			((ScriptID global102 0) dispose:)
			(DisposeScript 22)
			(DisposeScript 23)
			(DisposeScript 24)
		)
		(if (== (gLongSong number?) 69) (gLongSong fade:))
		(super newRoom: newRoomNumber)
	)
)

(instance reactorScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(pilot loop: 2 forceUpd:)
				(= cycles 15)
			)
			(1
				(if (proc0_13 1)
					(proc255_0 14 86)
					(= global136 4)
					(floorPanel dispose:)
				else
					(proc255_0 14 87)
					(= global136 3)
				)
				((gInv at: 3) moveTo: 14)
				(gGame changeScore: 5)
				(= cycles 10)
			)
			(2
				(pilot loop: 1 forceUpd:)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance wireScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(pilot loop: 2 forceUpd:)
				(= cycles 15)
			)
			(1
				(if (proc0_13 3)
					(proc255_0 14 88)
					(floorPanel dispose:)
					(= global136 4)
				else
					(proc255_0 14 89)
					(= global136 2)
				)
				((gInv at: 1) moveTo: 14)
				(gGame changeScore: 5)
				(= cycles 10)
			)
			(2
				(pilot loop: 1 forceUpd:)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance rampScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(ramp
						init:
						setLoop:
							(cond 
								((== global210 5) 2)
								((== global210 6) 3)
								((== global210 8) 5)
							)
						setCel: 1
						stopUpd:
					)
					(= seconds 2)
				else
					(= cycles 10)
				)
			)
			(1
				(if local1
					(ramp dispose:)
					(= local1 0)
					(global2 setScript: 0)
				else
					(ramp
						init:
						setCel: 1
						setLoop:
							(cond 
								((== global210 5) 2)
								((== global210 6) 3)
								((== global210 8) 5)
							)
						setCel: 1
						stopUpd:
					)
					(= cycles 5)
				)
			)
			(2
				(global2
					newRoom:
						(cond 
							((== global210 5) 62)
							((== global210 6) 49)
							((== global210 8) 80)
						)
				)
			)
		)
	)
)

(instance arrivalScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (proc255_0 14 90 67 -1 130 70 280 91))
				(gLongSong fade:)
				(= seconds 4)
			)
			(1
				(proc0_12)
				(= local0 0)
				(global2 newRoom: 17)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(self changeState: 1)
	)
)

(instance wallCScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== global206 2)
			(if (> (wallA y?) 161) (wallA stopUpd:))
			(if (> (wallB y?) 166) (wallB stopUpd:))
		)
		(if (== global206 1)
			(if (< (wallA y?) 120) (wallA stopUpd:))
			(if (< (wallB y?) 123) (wallB stopUpd:))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global206 2)
					(proc0_2)
					(if (== global207 2)
						(wallA dispose:)
						(wallB dispose:)
						(wallC setLoop: 1 setCel: 2 posn: 161 98)
						(proc0_10)
						(proc255_0 14 91)
						(global2 setScript: 0)
						(global2 newRoom: 17)
					else
						(= cycles 3)
					)
				)
				(if (== global206 1) (proc0_2) (self changeState: 2))
			)
			(1
				(thunder play:)
				(ShakeScreen 15)
				(if global601
					(proc255_0 14 92 67 -1 130 70 280)
				else
					(proc255_0 14 93 67 -1 130 70 280)
					(= global601 1)
				)
				(= cycles 15)
			)
			(2
				(wallC
					setMotion: MoveTo 161 (if (== global206 2) 98 else 67) self
				)
				(wallB
					setMotion: MoveTo 161 (if (== global206 2) 181 else 119)
				)
				(wallA
					setMotion: MoveTo 161 (if (== global206 2) 209 else 118)
				)
			)
			(3
				(if (== global206 2)
					(if global207
						(proc255_0 14 94 67 -1 130 70 280)
						(= global207 2)
						(global2 newRoom: 17)
					else
						(blowUp play:)
						(ShakeScreen 30)
						(proc255_0 14 95)
						(proc0_17 0 0 5 7)
					)
				else
					(proc255_0 14 96)
					(wallA stopUpd:)
					(wallB stopUpd:)
					(wallC stopUpd:)
					(= global206 0)
					(proc0_3)
					(= global100 0)
				)
			)
		)
	)
)

(instance pilot of View
	(properties)
	
	(method (init)
		(super init:)
		(self view: 31 ignoreActors: 1)
	)
)

(instance floorPanel of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 28
			setLoop: 0
			setCel: 0
			ignoreActors:
			posn: 95 190
			stopUpd:
		)
	)
)

(instance ramp of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 28
			setCel: 1
			setPri: 14
			ignoreActors: 1
			posn: 159 189
		)
	)
)

(instance lp1 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 0
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp2 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 2
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp3 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 1
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp4 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 3
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance wallA of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 28
			setCel: 0
			ignoreActors: 1
			x: 161
			y: (if (== global206 1) 210 else 117)
			setPri: 6
			setStep: 1 3
			stopUpd:
		)
	)
)

(instance wallB of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 28
			ignoreActors: 1
			x: 161
			y: (if (== global206 1) 182 else 120)
			setPri: 5
			setStep: 1 2
			stopUpd:
		)
	)
)

(instance wallC of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 28
			ignoreActors: 1
			x: 161
			y: (if (== global206 1) 98 else 67)
			setPri: 4
			setStep: 1 1
			stopUpd:
			setScript: wallCScript
		)
	)
)

(instance blowUp of Sound
	(properties
		number 33
		priority 1
	)
)

(instance thunder of Sound
	(properties
		number 31
		priority 1
	)
)

(instance powerDown of Sound
	(properties
		number 83
		priority 2
	)
)
