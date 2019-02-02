
JC=javac

classes=\
	history/SimpleHistory.class \
	history/UpdateHistory.class \
	init/ArgumentInitializer.class \
	init/SimpleInitializer.class \
	init/Starter.class \
	message/DataMessage.class \
	message/DumpMessage.class \
	message/JSONParser.class \
	message/Message.class \
	message/NoRouteMessage.class \
	message/RouteUpdateMessage.class \
	message/TableMessage.class \
	message/Type.class \
	neighbor/Neighbor.class \
	neighbor/NeighborRelation.class \
	neighbor/SimpleController.class \
	neighbor/SimpleNeighbor.class \
	neighbor/SocketController.class \
	routing/ForwardingEntry.class \
	routing/ForwardingTable.class \
	routing/Origin.class \
	routing/Router.class \
	routing/SimpleEntry.class \
	routing/SimpleRouter.class \
	routing/SimpleTable.class


default:
	$(JC) -XDignore.symbol.file --add-exports java.base/sun.security.x509=ALL-UNNAMED -cp \* $(classes:.class=.java)

