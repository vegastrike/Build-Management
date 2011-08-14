/*
 * NodePointerArgumentDisplay.java
 *
 * Created on February 13, 2007, 8:29 PM
 */

package campaigneditor.display;

import campaigneditor.AbstractCampaignNode;
import campaigneditor.Campaign;
import campaigneditor.arguments.Argument;
import campaigneditor.arguments.NodePointerArgument;
import campaigneditor.display.GeneralListPicker.PickerType;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author  daniel
 */
public class NodePointerArgumentDisplay extends ArgumentDisplay
{

    private NodePointerArgument argument;
    private Object[] selections = new Object[0];

    /** Creates a new instance of NodePointerListArgumentDisplay */
    public NodePointerArgumentDisplay(NodePointerArgument argument, Object selection)
    {
        System.out.println("selections a plenty");
        this.argument = argument;
        this.selections = selections;
        initialiseDisplay();
    }
    public NodePointerArgumentDisplay(NodePointerArgument argument)
    {
        System.out.println("no selections");
        this.argument = argument;
        initialiseDisplay();
    }
    public NodePointerArgumentDisplay()
    {
        System.out.println("selections none");
        this.argument = new NodePointerArgument("NodePointer");
        initialiseDisplay();
    }
    private void initialiseDisplay()
    {
        initComponents();
        reinitialiseDisplay();
    }
    private void reinitialiseDisplay()
    {
        this.pointerArgLabel.setText(this.argument.getLabel()+" (Node Pointer Argument)");
        this.pointerArgCombo.removeAllItems();
        this.pointerArgCombo.addItem(null);
        for (Object arg : this.selections)
        {
            this.pointerArgCombo.addItem(arg);
        }
        this.pointerArgCombo.setSelectedItem(this.argument);
    }
    public Argument getArgument()
    {
        return this.argument;
    }
    public void updateDisplay()
    {
        this.reinitialiseDisplay();
    }
    public void updateArgument()
    {
        Object item = this.pointerArgCombo.getSelectedItem();
        if (item == null)
        {
            item = new Object();
        }
        this.argument.setValue(item.toString());
    }
    public void setArgument(Argument argument)
    {
        NodePointerArgument newarg = (NodePointerArgument) argument;
        this.argument = newarg;
        reinitialiseDisplay();
    }
    public void setCampaign(Campaign campaign)
    {
        AbstractCampaignNode[] nodelist = campaign.getNodeList();
        NodePointerArgument[] nodenamelist = new NodePointerArgument[nodelist.length];
        for (int i = 0 ; i < nodelist.length ; i++)
        {
            nodenamelist[i] = new NodePointerArgument();
            nodenamelist[i].setValue(nodelist[i].getName());
        }
        this.selections = nodenamelist;
        this.reinitialiseDisplay();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        pointerArgLabel = new javax.swing.JLabel();
        pointerArgCombo = new javax.swing.JComboBox();

        pointerArgLabel.setText("Argument Label");

        pointerArgCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(pointerArgCombo, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                    .addComponent(pointerArgLabel))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pointerArgLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pointerArgCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox pointerArgCombo;
    private javax.swing.JLabel pointerArgLabel;
    // End of variables declaration//GEN-END:variables
    
}
