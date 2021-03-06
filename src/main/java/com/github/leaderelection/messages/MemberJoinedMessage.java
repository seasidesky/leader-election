package com.github.leaderelection.messages;

import com.github.leaderelection.Epoch;
import com.github.leaderelection.Id;

/**
 * JOINED(P) is sent by node P when it first joins the network. A member receiving this message will
 * add P to its local membership list.
 * 
 * @author gaurav
 */
public final class MemberJoinedMessage implements Request {
  private static final long serialVersionUID = 1L;

  private Id senderId;
  private Epoch epoch;
  private RequestType type = RequestType.MEMBER_JOINED;

  public MemberJoinedMessage(final Id senderId, final Epoch epoch) {
    this.senderId = senderId;
    this.epoch = epoch;
  }

  @Override
  public RequestType getType() {
    return type;
  }

  @Override
  public Id getSenderId() {
    return senderId;
  }

  @Override
  public Epoch getEpoch() {
    return epoch;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((epoch == null) ? 0 : epoch.hashCode());
    result = prime * result + ((senderId == null) ? 0 : senderId.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof MemberJoinedMessage)) {
      return false;
    }
    MemberJoinedMessage other = (MemberJoinedMessage) obj;
    if (epoch == null) {
      if (other.epoch != null) {
        return false;
      }
    } else if (!epoch.equals(other.epoch)) {
      return false;
    }
    if (senderId == null) {
      if (other.senderId != null) {
        return false;
      }
    } else if (!senderId.equals(other.senderId)) {
      return false;
    }
    if (type != other.type) {
      return false;
    }
    return true;
  }

  // for ser-de
  private MemberJoinedMessage() {}

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("MemberJoinedMessage [senderId=").append(senderId).append(", epoch=")
        .append(epoch).append(", type=").append(type).append("]");
    return builder.toString();
  }

}
