/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
/**
 * Represents a stream of similar data (eg video) in a Container.<br>
 * <p><br>
 * Streams are really virtual concepts; Container objects really just contain<br>
 * a bunch of Packets.  But each Packet usually has a stream<br>
 * id associated with it, and all Packets with that stream id represent<br>
 * the same type of (usually time-based) data.  For example in many FLV<br>
 * video files, there is a stream with id "0" that contains all video data, and<br>
 * a stream with id "1" that contains all audio data.<br>
 * </p><p><br>
 * You use an Stream object to get properly configured Decoders<br>
 * for decoding, and to tell Encoders how to encode Packets when<br>
 * decoding.<br>
 * </p>
 */
public class ContainerStream extends RefCounted {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    Buffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected ContainerStream(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.ContainerStream_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected ContainerStream(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.ContainerStream_SWIGUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(ContainerStream obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new ContainerStream object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public ContainerStream copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new ContainerStream(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof ContainerStream)
      equal = (((ContainerStream)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  

  /**
   * Get an ordered sequence of index entries in this {@link Stream}.
   * 
   * @return A list of entries.  Will always return a non-null
   *   list, but if there are no entries the list size will be zero.
   */
  public java.util.List<IndexEntry> getIndexEntries()
  {
    final int numEntries = getNumIndexEntries();
    java.util.List<IndexEntry> retval = new java.util.ArrayList<IndexEntry>(Math.max(numEntries, 10));
    for(int i = 0; i < numEntries; i++) {
      final IndexEntry entry = getIndexEntry(i);
      if (entry != null) {
       retval.add(entry); 
      }
    }
    
    return retval;
  }


/**
 * Get the relative position this stream has in the hosting<br>
 * Container object.<br>
 * @return The Index within the Container of this stream.
 */
  public int getIndex() {
    return VideoJNI.ContainerStream_getIndex(swigCPtr, this);
  }

/**
 * Return a container format specific id for this stream.<br>
 * @return The (container format specific) id of this stream.
 */
  public int getId() {
    return VideoJNI.ContainerStream_getId(swigCPtr, this);
  }

/**
 * Get the (sometimes estimated) average frame rate of this container.<br>
 * For variable frame-rate containers (they do exist) this is just<br>
 * an approximation.  Better to use getTimeBase().<br>
 * <br>
 * For contant frame-rate containers, this will be 1 / ( getTimeBase() )<br>
 * <br>
 * @return The frame-rate of this container.
 */
  public Rational getFrameRate() {
    long cPtr = VideoJNI.ContainerStream_getFrameRate(swigCPtr, this);
    return (cPtr == 0) ? null : new Rational(cPtr, false);
  }

/**
 * The time base in which all timestamps (e.g. Presentation Time Stamp (PTS)<br>
 * and Decompression Time Stamp (DTS)) are represented.  For example<br>
 * if the time base is 1/1000, then the difference between a PTS of 1 and<br>
 * a PTS of 2 is 1 millisecond.  If the timebase is 1/1, then the difference<br>
 * between a PTS of 1 and a PTS of 2 is 1 second.<br>
 * <br>
 * @return The time base of this stream.
 */
  public Rational getTimeBase() {
    long cPtr = VideoJNI.ContainerStream_getTimeBase(swigCPtr, this);
    return (cPtr == 0) ? null : new Rational(cPtr, false);
  }

/**
 * Return the start time, in #getTimeBase() units, when this stream<br>
 * started.<br>
 * @return The start time.
 */
  public long getStartTime() {
    return VideoJNI.ContainerStream_getStartTime(swigCPtr, this);
  }

/**
 * Return the duration, in #getTimeBase() units, of this stream,<br>
 * or Global#NO_PTS if unknown.<br>
 * @return The duration (in getTimeBase units) of this stream, if known.
 */
  public long getDuration() {
    return VideoJNI.ContainerStream_getDuration(swigCPtr, this);
  }

/**
 * The current Decompression Time Stamp that will be used on this stream,<br>
 * in #getTimeBase() units.<br>
 * @return The current Decompression Time Stamp that will be used on this stream.
 */
  public long getCurrentDts() {
    return VideoJNI.ContainerStream_getCurrentDts(swigCPtr, this);
  }

/**
 * Get the number of index entries in this stream.<br>
 * @return The number of index entries in this stream.<br>
 * @see #getIndexEntry(int)
 */
  public int getNumIndexEntries() {
    return VideoJNI.ContainerStream_getNumIndexEntries(swigCPtr, this);
  }

/**
 * Returns the number of encoded frames if known.  Note that frames here means<br>
 * encoded frames, which can consist of many encoded audio samples, or<br>
 * an encoded video frame.<br>
 * <br>
 * @return The number of frames (encoded) in this stream.
 */
  public long getNumFrames() {
    return VideoJNI.ContainerStream_getNumFrames(swigCPtr, this);
  }

/**
 * Gets the sample aspect ratio.<br>
 * <br>
 * @return The sample aspect ratio.
 */
  public Rational getSampleAspectRatio() {
    long cPtr = VideoJNI.ContainerStream_getSampleAspectRatio(swigCPtr, this);
    return (cPtr == 0) ? null : new Rational(cPtr, false);
  }

/**
 * Get the underlying container for this stream, or null if Humble Video<br>
 * doesn't know.<br>
 * <br>
 * @return the container, or null if we don't know.
 */
  public Container getContainer() {
    long cPtr = VideoJNI.ContainerStream_getContainer(swigCPtr, this);
    return (cPtr == 0) ? null : new Container(cPtr, false);
  }

/**
 * Get how the decoding codec should parse data from this stream.<br>
 * @return the parse type.
 */
  public ContainerStream.ParseType getParseType() {
    return ContainerStream.ParseType.swigToEnum(VideoJNI.ContainerStream_getParseType(swigCPtr, this));
  }

/**
 * Set the parse type the decoding codec should use.  Set to<br>
 * ParseType#PARSE_NONE if you don't want any parsing<br>
 * to be done.<br>
 * <p><br>
 * Warning: do not set this flag unless you know what you're doing,<br>
 * and do not set after you've started reading packets.<br>
 * </p><br>
 * <br>
 * @param type The type to set.
 */
  public void setParseType(ContainerStream.ParseType type) {
    VideoJNI.ContainerStream_setParseType(swigCPtr, this, type.swigValue());
  }

/**
 * Get the KeyValueBag for this object,<br>
 * or null if none.<br>
 * <p><br>
 * If the Container or Stream object<br>
 * that this KeyValueBag came from was opened<br>
 * for reading, then changes via KeyValueBag#setValue(String, String)<br>
 * will have no effect on the underlying media.<br>
 * </p><br>
 * <p><br>
 * If the Container or Stream object<br>
 * that this KeyValueBag came from was opened<br>
 * for writing, then changes via KeyValueBag#setValue(String, String)<br>
 * will have no effect after Container#writeHeader()<br>
 * is called.<br>
 * </p><br>
 * @return the KeyValueBag.
 */
  public KeyValueBag getMetaData() {
    long cPtr = VideoJNI.ContainerStream_getMetaData(swigCPtr, this);
    return (cPtr == 0) ? null : new KeyValueBag(cPtr, false);
  }

/**
 * Search for the given time stamp in the key-frame index for this Stream.<br>
 * <p><br>
 * Not all ContainerFormat implementations<br>
 * maintain key frame indexes, but if they have one,<br>
 * then this method searches in the Stream index<br>
 * to quickly find the byte-offset of the nearest key-frame to<br>
 * the given time stamp.<br>
 * </p><br>
 * @param wantedTimeStamp the time stamp wanted, in the stream's<br>
 *                        time base units.<br>
 * @param flags A bitmask of the <code>SEEK_FLAG_*</code> flags, or 0 to turn<br>
 *              all flags off.  If Container#SEEK_FLAG_BACKWARDS then the returned<br>
 *              index will correspond to the time stamp which is &lt;=<br>
 *              the requested one (not supported by all demuxers).<br>
 *              If Container#SEEK_FLAG_BACKWARDS is not set then it will be &gt;=.<br>
 *              if Container#SEEK_FLAG_ANY seek to any frame, only<br>
 *              keyframes otherwise (not supported by all demuxers).<br>
 * @return The IndexEntry for the nearest appropriate timestamp<br>
 *   in the index, or null if it can't be found.
 */
  public IndexEntry findTimeStampEntryInIndex(long wantedTimeStamp, int flags) {
    long cPtr = VideoJNI.ContainerStream_findTimeStampEntryInIndex(swigCPtr, this, wantedTimeStamp, flags);
    return (cPtr == 0) ? null : new IndexEntry(cPtr, false);
  }

/**
 * Search for the given time stamp in the key-frame index for this Stream.<br>
 * <p><br>
 * Not all ContainerFormat implementations<br>
 * maintain key frame indexes, but if they have one,<br>
 * then this method searches in the Stream index<br>
 * to quickly find the index entry position of the nearest key-frame to<br>
 * the given time stamp.<br>
 * </p><br>
 * @param wantedTimeStamp the time stamp wanted, in the stream's<br>
 *                        time base units.<br>
 * @param flags A bitmask of the <code>SEEK_FLAG_*</code> flags, or 0 to turn<br>
 *              all flags off.  If Container#SEEK_FLAG_BACKWARDS then the returned<br>
 *              index will correspond to the time stamp which is &lt;=<br>
 *              the requested one (not supported by all demuxers).<br>
 *              If Container#SEEK_FLAG_BACKWARDS is not set then it will be &gt;=.<br>
 *              if Container#SEEK_FLAG_ANY seek to any frame, only<br>
 *              keyframes otherwise (not supported by all demuxers).<br>
 * @return The position in this Stream index, or -1 if it cannot<br>
 *   be found or an index is not maintained.<br>
 * @see #getIndexEntry(int)
 */
  public int findTimeStampPositionInIndex(long wantedTimeStamp, int flags) {
    return VideoJNI.ContainerStream_findTimeStampPositionInIndex(swigCPtr, this, wantedTimeStamp, flags);
  }

/**
 * Get the IndexEntry at the given position in this<br>
 * Stream object's index.<br>
 * <p><br>
 * Not all ContainerFormat types maintain<br>
 * Stream indexes, but if they do,<br>
 * this method can return those entries.<br>
 * </p><br>
 * <p><br>
 * Do not modify the Container this stream<br>
 * is from between calls to this method and<br>
 * #getNumIndexEntries() as indexes may<br>
 * be compacted while processing.<br>
 * </p><br>
 * @param position The position in the index table.
 */
  public IndexEntry getIndexEntry(int position) {
    long cPtr = VideoJNI.ContainerStream_getIndexEntry(swigCPtr, this, position);
    return (cPtr == 0) ? null : new IndexEntry(cPtr, false);
  }

/**
 * Get the Stream.Disposition of this stream.
 */
  public ContainerStream.Disposition getDisposition() {
    return ContainerStream.Disposition.swigToEnum(VideoJNI.ContainerStream_getDisposition(swigCPtr, this));
  }

/**
 * For containers with Stream.Disposition.DISPOSITION_ATTACHED_PIC,<br>
 * this returns a read-only copy of the packet containing the<br>
 * picture (needs to be decoded separately).
 */
  public MediaPacket getAttachedPic() {
    long cPtr = VideoJNI.ContainerStream_getAttachedPic(swigCPtr, this);
    return (cPtr == 0) ? null : new MediaPacket(cPtr, false);
  }

  /**
   * The disposition of this stream. Some streams can have special<br>
   * meanings in some Containers.
   */
  public enum Disposition {
    DISPOSITION_NONE(VideoJNI.ContainerStream_DISPOSITION_NONE_get()),
    DISPOSITION_DEFAULT(VideoJNI.ContainerStream_DISPOSITION_DEFAULT_get()),
    DISPOSITION_DUB(VideoJNI.ContainerStream_DISPOSITION_DUB_get()),
    DISPOSITION_ORIGINAL(VideoJNI.ContainerStream_DISPOSITION_ORIGINAL_get()),
    DISPOSITION_COMMENT(VideoJNI.ContainerStream_DISPOSITION_COMMENT_get()),
    DISPOSITION_LYRICS(VideoJNI.ContainerStream_DISPOSITION_LYRICS_get()),
    DISPOSITION_KARAOKE(VideoJNI.ContainerStream_DISPOSITION_KARAOKE_get()),
  /**
   * Track should be used during playback by default.<br>
   * Useful for subtitle track that should be displayed<br>
   * even when user did not explicitly ask for subtitles.
   */
    DISPOSITION_FORCED(VideoJNI.ContainerStream_DISPOSITION_FORCED_get()),
  /**
   * stream for hearing impaired audiences 
   */
    DISPOSITION_HEARING_IMPAIRED(VideoJNI.ContainerStream_DISPOSITION_HEARING_IMPAIRED_get()),
  /**
   * stream for visual impaired audiences  stream without voice 
   */
    DISPOSITION_VISUAL_IMPAIRED(VideoJNI.ContainerStream_DISPOSITION_VISUAL_IMPAIRED_get()),
    DISPOSITION_CLEAN_EFFECTS(VideoJNI.ContainerStream_DISPOSITION_CLEAN_EFFECTS_get()),
  /**
   * The stream is stored in the file as an attached picture/"cover art" (e.g.<br>
   * APIC frame in ID3v2). The single packet associated with it will be returned<br>
   * among the first few packets read from the file unless seeking takes place.<br>
   * It can also be accessed at any time in #getAttachedPic().
   */
    DISPOSITION_ATTACHED_PIC(VideoJNI.ContainerStream_DISPOSITION_ATTACHED_PIC_get()),
  ;

    public final int swigValue() {
      return swigValue;
    }

    public static Disposition swigToEnum(int swigValue) {
      Disposition[] swigValues = Disposition.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (Disposition swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + Disposition.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private Disposition() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private Disposition(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private Disposition(Disposition swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

  /**
   * What types of parsing can we do on a call to<br>
   * Source#read(Packet)
   */
  public enum ParseType {
  /**
   * No special instructions 
   */
    PARSE_NONE(VideoJNI.ContainerStream_PARSE_NONE_get()),
  /**
   * full parsing and repack 
   */
    PARSE_FULL(VideoJNI.ContainerStream_PARSE_FULL_get()),
  /**
   * Only parse headers, do not repack. 
   */
    PARSE_HEADERS(VideoJNI.ContainerStream_PARSE_HEADERS_get()),
  /**
   * full parsing and interpolation of timestamps for frames not starting on a packet boundary 
   */
    PARSE_TIMESTAMPS(VideoJNI.ContainerStream_PARSE_TIMESTAMPS_get()),
  /**
   * full parsing and repack of the first frame only, only implemented for H.264 currently 
   */
    PARSE_FULL_ONCE(VideoJNI.ContainerStream_PARSE_FULL_ONCE_get()),
  /**
   * full parsing and repack with timestamp and position generation by parser for raw<br>
   * this assumes that each packet in the file contains no demuxer level headers and<br>
   * just codec level data, otherwise position generation would fail 
   */
    PARSE_FULL_RAW(VideoJNI.ContainerStream_PARSE_FULL_RAW_get()),
  ;

    public final int swigValue() {
      return swigValue;
    }

    public static ParseType swigToEnum(int swigValue) {
      ParseType[] swigValues = ParseType.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (ParseType swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + ParseType.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private ParseType() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private ParseType(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private ParseType(ParseType swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
