;;; Sierra Script 1.0 - (do not remove this comment)
(script# 700)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)

(public
	junkBay 0
)

(instance junkBay of Locale
	(properties)
	
	(method (handleEvent pEvent &tmp [temp0 50])
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					(
					(Said 'get,get[<up]/iron,scrap,debris,heap[<sharp]') (proc255_0 700 0))
					(
						(Said
							'get,manipulate,feel/(edge[<jagged]),(programmer[<barbed])'
						)
						(proc255_0 700 1)
					)
					((Said 'eat/iron,scrap,debris,heap[<sharp]') (proc255_0 700 2))
					((Said 'expectorate') (proc255_0 700 3))
					((Said 'write,swing') (proc255_0 700 4))
					((Said 'listen') (proc255_0 700 5))
					((Said 'kiss') (proc255_0 700 6))
					((Said 'clean') (proc255_0 700 7))
					((Said 'eat/ass') (proc255_0 700 8))
					((Said 'beat') (proc255_0 700 9))
					(
						(Said
							'press,manipulate,roll/iron,scrap,debris,heap[<sharp]'
						)
						(proc255_0 700 10)
					)
					((Said 'holler,whistle,laugh[<out]') (proc255_0 700 11))
					((Said 'cry[<out]') (proc255_0 700 12))
					((Said 'use/cable')
						(if (gEgo has: 1)
							(proc255_0 700 13)
						else
							(proc255_0 700 14)
						)
					)
					((Said 'tie') (proc255_0 700 15))
					(
					(Said 'climb/iron,building,heap,debris,scrap[<sharp]') (proc255_0 700 16))
					((Said 'use,climb,stand,erect,lean/ladder') (if (gEgo has: 2) (proc255_0 700 17) else (proc0_9)))
					((Said 'look>')
						(cond 
							(
								(or
									(Said '[<up,above,at]/ceiling')
									(Said '<up,above,at[/ceiling]')
								)
								(proc255_0 700 18)
							)
							(
								(and
									(!= gGGNorth gGNorth)
									(or
										(Said '[<down,below,at]/dirt,deck')
										(Said '<down,below,at[/dirt,deck]')
									)
								)
								(proc255_0 700 19)
							)
							((Said '/console') (proc255_0 700 20))
							((Said '/banister,banister,beam') (proc255_0 700 21))
							((Said '/partition,console[<pod,e,north,w]') (proc255_0 700 22))
							(
								(Said
									'[<in,at,through]/debris,heap,iron,garbage,end,debris,scrap'
								)
								(proc255_0 700 23)
							)
							((Said '/(edge[<jagged]),(programmer[<barbed])') (proc255_0 700 1))
							((Said '/dirt') (proc255_0 700 24))
							((Said '/paint,coolant') (proc255_0 700 25))
							((Said '/lamp') (proc255_0 700 26))
							((Said '/conduit,frame') (proc255_0 700 27))
							((Said '/console') (proc255_0 700 28))
							((Said '/self') (proc255_0 700 29))
							((Said '/appendage,head,leg,body,self') (proc255_0 700 30))
						)
					)
					((Said 'nap,(lie<down)[/deck]') (proc255_0 700 31))
					((Said '*/cable[<*]') (proc255_0 700 32))
					((Said 'drop,hold[<in]/crystal[<glowing]/mouth') (proc255_0 700 33))
					((Said 'eat,break/crystal[<glowing]') (proc255_0 700 34))
					((Said 'dig[/cavity]') (proc255_0 700 35))
					((Said 'climb/banister,beam,banister<up<to') (proc255_0 700 36))
					((Said 'climb') (proc255_0 700 37))
					((Said 'jump/craft') (proc255_0 700 38))
					(
						(Said
							'hoist,open,manipulate,press,drag,bend/deck,console'
						)
						(proc255_0 700 39)
					)
					((Said 'get/tile[<rib,deck]') (proc255_0 700 40))
				)
				(if
					(and
						(== gGGNorth gGNorth)
						(Said 'use,(turn<on)/motivator,artifact,device')
					)
					(proc255_0 700 41)
				)
			)
		)
	)
)
