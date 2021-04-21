package com.example.recycleview_v0;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_v0.Object.Order;
import com.example.recycleview_v0.View.SquareImageView;

import java.util.List;

/**
 * 專案名稱:recycleview_v0
 * 類描述:
 * 建立人:user01
 * 建立時間:2020/9/11 上午 09:16
 * 修改人:user01
 * 修改時間:2020/9/11 上午 09:16
 * 修改備註:
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context ;
    private List<Order> orderList;
    private final LayoutInflater mLayoutInflater;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cardView;
        public TextView orderTime;
        public TextView deliveryTime;
        public TextView vegetableName;
        public TextView number;
        public TextView price;
        public TextView customerName;
        public TextView customerPhoneNumber;
        public TextView remark;
        public SquareImageView imageView;

        public MyViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.cd_vegetable_id);

            orderTime = v.findViewById(R.id.cd_orderTime);
            deliveryTime = v.findViewById(R.id.cd_deliveryTime);
            vegetableName = v.findViewById(R.id.cd_vegetableName);
            number = v.findViewById(R.id.cd_number);
            price = v.findViewById(R.id.cd_price);
            customerName = v.findViewById(R.id.cd_customerName);
            customerPhoneNumber = v.findViewById(R.id.cd_customerPhoneNumber);
            remark = v.findViewById(R.id.cd_remark);

            imageView = v.findViewById(R.id.cardview_image);
        }
    }

    public void addItem(){
        Order oo = new Order();
        oo.setorderTime("2020/09/11");
        oo.setdeliveryTime("2020/09/13");
        oo.setvegetableName("新項目");
        oo.setvegetableID("0003");
        oo.setnumber("1包");
        oo.setprice("100元");
        oo.setcustomerName("農會吳小姐");
        oo.setcustomerPhoneNumber("0915833602");
        oo.setremark("竹筍大小不拘");
        orderList.add(-1,oo);
    }

    public void removeItem(int position){

    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(context).inflate(R.layout.cardview_vegetable,parent,false);

        final MyViewHolder vh = new MyViewHolder(cardView);
        vh.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("****",orderList.get(vh.getAdapterPosition()).getvegetableName());
            }
        });
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)從這裡覆寫 決定cardView裡面的內容
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.orderTime.setText(orderList.get(position).getorderTime());
        holder.deliveryTime.setText(orderList.get(position).getdeliveryTime());
        holder.vegetableName.setText(orderList.get(position).getvegetableName());
        holder.number.setText(orderList.get(position).getnumber());
        holder.price.setText(orderList.get(position).getprice());
        holder.customerName.setText(orderList.get(position).getcustomerName());
        holder.customerPhoneNumber.setText(orderList.get(position).getcustomerPhoneNumber());
        holder.remark.setText(orderList.get(position).getremark());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
