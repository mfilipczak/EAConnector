package com.cgi.tools.eaconnector.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class EaTags.
 */
public class EaTags {

    /** The Constant TAG_IDENTIFIER. */
    public static final String TAG_IDENTIFIER = "@";

    /** The Constant TAG_SEPARATOR. */
    public static final String TAG_SEPARATOR = "\\s";

    /** The Constant TAGID_INTRODUCED. */
    public static final String TAGID_INTRODUCED = "introduced";

    /** The Constant TAGID_USED. */
    public static final String TAGID_USED = "used";

    /** The Constant TAGID_MODIFIED. */
    public static final String TAGID_MODIFIED = "modified";

    /** The Constant TAGID_IMPLEMENTED. */
    public static final String TAGID_IMPLEMENTED = "implemented";

    /** The Constant TAGID_REMOVED. */
    public static final String TAGID_REMOVED = "removed";

    /** The Constant TAGID_INTERFACE_MODIFIED_ONLY. */
    public static final String TAGID_INTERFACE_MODIFIED_ONLY = "interfaceOnlyModified";

    /** The Constant TAGID_CONFIGURED. */
    public static final String TAGID_CONFIGURED = "configured";

    /** The Constant TAGID_DESRIPTION. */
    public static final String TAGID_DESRIPTION = "description";

    /** The Constant TAGID_INTERFACE. */
    public static final String TAGID_INTERFACE = "interface";

    /** The Constant REPO_ID */
    public static final String REPO_ID = "RepoId";
    
    /** The Constant PARENT_REPO_ID */
    public static final String PARENT_REPO = "ParentRepo";
    /** The tag map. */
    Map<String, List<String>> tagMap;

    /** The tag strings map. */
    Map<String, String> tagStringsMap;

    /**
     * Instantiates a new ea tags.
     * 
     * @param eaObjectNotes
     *            the ea object notes
     */
    public EaTags(String eaObjectNotes) {
        tagMap = new HashMap<String, List<String>>();
        tagStringsMap = new HashMap<String, String>();
        this.fillTagMap(eaObjectNotes);
    }

    /**
     * Fill tag map.
     * 
     * @param notes
     *            the notes
     */
    private void fillTagMap(String notes) {
        notes = fixEaNotesString(notes);
        if ((notes == null) || (notes.equals("")))
            return;
        if (notes.indexOf(TAG_IDENTIFIER) == -1)
            return;
        // Only a line starting with @ is treated as a begin of tag.
        // Tag key is characters directly after @, until first whitespace char
        // Tag value is everything after tag key until next tag id is found.
        String tagKey = null;
        String stringTagValue = "";
        List<String> tagWords = null;
        String[] lines = notes.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line.startsWith(TAG_IDENTIFIER)) {
                // if it is not a first tag in these notes, write previous one
                // to the tag map
                if (tagKey != null) {
                    tagStringsMap.put(tagKey, stringTagValue.trim());
                    if(tagMap.get(tagKey)!= null) {
                        tagMap.get(tagKey).addAll(tagWords);
                    }else {
                        tagMap.put(tagKey, tagWords);
                    }
                }
                String[] tagElements = line.split(TAG_SEPARATOR);
                tagKey = tagElements[0].substring(1, tagElements[0].length())
                        .trim();

                if (tagElements.length > 1)
                    stringTagValue = line.substring(line
                            .indexOf(tagElements[1]), line.length())
                            + "\n";
                else
                    stringTagValue = "";
                tagWords = new ArrayList<String>();
                if(stringTagValue.trim().matches(".*\".*\"")) {
                    tagWords.add(stringTagValue);
                }else {
                for (int j = 1; j < tagElements.length; j++) {
                    tagWords.add(tagElements[j].trim());
                }
                }
            } else {
                stringTagValue += line + "\n";
                if (tagWords != null) {
                    if(line.trim().matches(".*\".*\"")) {
                        tagWords.add(line.trim());
                    }else {
                    String[] tagElements = line.split(TAG_SEPARATOR);
                    for (int j = 0; j < tagElements.length; j++) {
                        tagWords.add(tagElements[j].trim());
                    }
                    }
                }
            }
        }
        // if there has been any tag specified, write the last one to the tag
        // map
        if (tagKey != null) {
            tagStringsMap.put(tagKey, stringTagValue.trim());
            if(tagMap.get(tagKey)!= null) {
                tagMap.get(tagKey).addAll(tagWords);
            }else {
                tagMap.put(tagKey, tagWords);
            }
        }
    }

    /**
     * Gets the tags map.
     * 
     * @return the tags map
     */
    public Map<String, List<String>> getTagsMap() {
        return tagMap;
    }

    /**
     * Gets the tag values.
     * 
     * @param tag
     *            the tag
     * @return the tag values
     */
    public List<String> getTagValues(String tag) {
        if (tagMap == null)
            return null;
        return tagMap.get(tag);
    }

    /**
     * Gets the tag string value.
     * 
     * @param tag
     *            the tag
     * @return the tag string value
     */
    public String getTagStringValue(String tag) {
        if (tagStringsMap == null)
            return "";
        String outString = tagStringsMap.get(tag.trim());
        if (outString == null)
            outString = "";
        return outString;
    }

    /**
     * Gets the desription for project.
     * 
     * @param projectName
     *            the project name
     * @return the desription for project
     */
    public String getDesriptionForProject(String projectName) {
        if (tagMap == null)
            return "";
        String description = "";
        String generalDesc = tagStringsMap.get(TAGID_DESRIPTION);
        if (generalDesc != null)
            description += generalDesc;
        if ((projectName != null) && (!projectName.equals(""))) {
            String projectDesc = tagStringsMap.get(TAGID_DESRIPTION + "("
                    + projectName + ")");
            if ((projectDesc != null) && (!projectDesc.equals("")))
                if (description != "")
                    description += "\n";
            description += projectDesc;
        }

        return description.trim();
    }

    /**
     * Checks for tag.
     * 
     * @param tag
     *            the tag
     * @return true, if successful
     */
    public boolean hasTag(String tag) {
        if (tagMap == null)
            return false;
        return tagMap.containsKey(tag);
    }

    /**
     * Checks for tag value.
     * 
     * @param tag
     *            the tag
     * @param value
     *            the value
     * @return true, if successful
     */
    public boolean hasTagValue(String tag, String value) {
        if (tagMap == null)
            return false;
        List<String> l = tagMap.get(tag);
        if (l == null)
            return false;

        return l.contains(value);
    }

    /**
     * Checks for tag value.
     * 
     * @param value
     *            the value
     * @return true, if successful
     */
    public boolean hasTagValue(String value) {
        if (tagMap == null)
            return false;
        Set<String> keySet = tagMap.keySet();
        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            if (this.hasTagValue(key, value))
                return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (tagMap == null)
            return "null";
        String outString = "";
        Set<String> keySet = tagMap.keySet();
        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            outString += "@" + key + ": ";
            List<String> values = tagMap.get(key);
            for (Iterator<String> iterator = values.iterator(); iterator
                    .hasNext();) {
                String value = iterator.next();
                outString += value + " ";
            }
            outString += "; ";
        }
        return outString;
    }

    /**
     * Fix ea notes string.
     * 
     * @param notesString
     *            the notes string
     * @return the string
     */
    public static String fixEaNotesString(String notesString) {
        if ((notesString == null) || (notesString.equals("")))
            return "";
        String outStr = notesString;
        // Notes retrieved from database are represented as html code.
        // First, the HTML tags, have to be replaced for the need of Formating
        // MS Word Macro
        outStr = outStr.replace("<", "<#FormatMarker#");
        // Now, the special characters like >, &, etc, have to be replaced.
        outStr = outStr.replace("&lt;", "<");
        outStr = outStr.replace("&gt;", ">");
        outStr = outStr.replace("&amp;", "&");
        outStr = outStr.replace("&quot;", "\"");
        outStr = outStr.replace("&ndash;", "-");
        outStr = outStr.replace("&rsquo;", "'");
        outStr = outStr.replace("&ldquo;", "\"");
        outStr = outStr.replace("&rdquo;", "\"");
        return outStr;
    }

    /**
     * Gets the available tags.
     * 
     * @return the available tags
     */
    public Set<String> getAvailableTags() {
        return tagStringsMap.keySet();
    }

}
