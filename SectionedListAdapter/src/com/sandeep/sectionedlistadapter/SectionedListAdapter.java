package com.sandeep.sectionedlistadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class SectionedListAdapter<T1,T2> extends BaseAdapter
{

    private ListItemLinkedList mElements;

    protected static final int VIEW_TYPE_COUNT = 2;

    protected static final int TYPE_HEADER = 1;
    protected static final int TYPE_CHILD = 0;

    public SectionedListAdapter(LinkedHashMap<T1, ? extends List<T2>> data)
    {
        mElements = new ListItemLinkedList(data);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public Object getItem(int position)
    {
        return mElements.get(position).getData();
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return getCount() == 0;
    }

    @Override
    public int getCount()
    {
        return mElements.size();
    }

    @Override
    public int getViewTypeCount()
    {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position)
    {
        return mElements.get(position).getType();
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent)
    {
        int viewType = getItemViewType(position);

        if (viewType == TYPE_HEADER)
        {
            return getHeaderView(position, convertView, parent);
        }

        if (viewType == TYPE_CHILD)
        {
            return getChildView(position, convertView, parent);
        }

        return null;
    }

    /**
     * Implement this method to return the view that will be used as the section header
     * 
     * @see BaseAdapter#getView(int, View, ViewGroup)
     */
    protected abstract View getHeaderView(int position, View convertView, ViewGroup parent);

    /**
     * Implement this this method to return the view that will be used as the list item
     * 
     * @see BaseAdapter#getView(int, View, ViewGroup)
     */
    protected abstract View getChildView(int position, View convertView, ViewGroup parent);


    @Override
    public boolean isEnabled(int position)
    {
        return getItemViewType(position) != TYPE_HEADER;
    }

    @Override
    public boolean areAllItemsEnabled()
    {
        return false;
    }

    /**
     * Sets the data in the adapter. This replaces existing data, if any, in the adapter.
     * @param data The HashMap data to set in the adapter
     */
    public void setData(LinkedHashMap<T1, ? extends List<T2>> data)
    {
        mElements = new ListItemLinkedList(data);
    }

    /**
     * Class to wrap together the underlying data of a list item and its view type
     * 
     * @param <K> The type of the data associated with this list item
     */
    private class ListItem<K>
    {
        private K mData;
        private int mType;

        public ListItem(K data, int type)
        {
            mData = data;
            mType = type;
        }

        public K getData()
        {
            return mData;
        }

        public int getType()
        {
            return mType;
        }

        @Override
        public boolean equals(Object o)
        {
            if (o == null || !(o instanceof ListItem))
            {
                return false;
            }

            ListItem<K> item;
            try
            {
                item = (ListItem<K>) o;
            }
            catch (ClassCastException e)
            {
                return false;
            }
            return this.getData().equals(item.getData()) && this.getType() == item.getType();
        }
    }

    /**
     * Linked list of ListItems
     * This is the collection that holds the data in a flattened linear structure
     */
    protected class ListItemLinkedList extends LinkedList<ListItem<?>>
    {
        private static final long serialVersionUID = 3624066110571101441L;

		public ListItemLinkedList(LinkedHashMap<T1, ? extends List<T2>> data)
        {
            Set<T1> sections = data.keySet();
            for (T1 section : sections)
            {
                // Add the header to the start of a group of items
                add(new ListItem<T1>(section,TYPE_HEADER));
                List<T2> children = data.get(section);
                int childCount = children.size();
                for (int i = 0; i < childCount; i++)
                {
                    add(new ListItem<T2>(children.get(i),TYPE_CHILD));
                }
            }
        }
    }
}




