//*************************************************************************************************
package j4de.net;
//*************************************************************************************************

//*************************************************************************************************
import java.util.UUID;
import java.util.List;
import java.nio.ByteBuffer;
//*************************************************************************************************

//*************************************************************************************************
public class ServerStateMsg extends NetMsg {

	//==============================================================================================
	private static NetMsgType TYPE = NetMsgType.SERVER_STATE; 
	//==============================================================================================
	
	//==============================================================================================
	private List<EntityState> entityStates = null;
	//==============================================================================================

	//==============================================================================================
	public List<EntityState> getEntityStates() {
		return this.entityStates;
	}
	//==============================================================================================

	//==============================================================================================
	public void marshal(ByteBuffer buffer) {
		buffer.putInt(TYPE.ordinal());
		buffer.putLong(uuid.getMostSignificantBits());
		buffer.putLong(uuid.getLeastSignificantBits());
		if (entityStates != null) {
			buffer.putInt(entityStates.size());
			for (EntityState entityState : entityStates) {
				entityState.marshal(buffer);
			}
		} else {
			buffer.putInt(0);
		}
	}
	//==============================================================================================

	//==============================================================================================
	public void unmarshal(ByteBuffer buffer) {
		long uuidMostSignificantBits  = buffer.getLong();
		long uuidLeastSignificantBits = buffer.getLong();
		this.uuid = new UUID(uuidMostSignificantBits, uuidLeastSignificantBits);
		int entityStateSize = buffer.getInt();
		if (entityStateSize > 0) {
			entityStates.clear();
			for (int i=0; i<entityStateSize; i++) {
				EntityState entityState = new EntityState();
				entityState.unmarshal(buffer);
				entityStates.add(entityState);
			}
		}
	}
	//==============================================================================================
	
}
//*************************************************************************************************
