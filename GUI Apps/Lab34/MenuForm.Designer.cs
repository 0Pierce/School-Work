namespace Lab34
{
    partial class MenuForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnManSubs = new System.Windows.Forms.Button();
            this.btnPubN = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnManSubs
            // 
            this.btnManSubs.BackColor = System.Drawing.Color.Lavender;
            this.btnManSubs.Cursor = System.Windows.Forms.Cursors.Cross;
            this.btnManSubs.Location = new System.Drawing.Point(39, 72);
            this.btnManSubs.Name = "btnManSubs";
            this.btnManSubs.Size = new System.Drawing.Size(195, 62);
            this.btnManSubs.TabIndex = 0;
            this.btnManSubs.Text = "Manage Subscriptions";
            this.btnManSubs.UseVisualStyleBackColor = false;
            this.btnManSubs.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnManSubs_Click);
            // 
            // btnPubN
            // 
            this.btnPubN.BackColor = System.Drawing.Color.Azure;
            this.btnPubN.Cursor = System.Windows.Forms.Cursors.Cross;
            this.btnPubN.Enabled = false;
            this.btnPubN.Location = new System.Drawing.Point(302, 72);
            this.btnPubN.Name = "btnPubN";
            this.btnPubN.Size = new System.Drawing.Size(195, 62);
            this.btnPubN.TabIndex = 1;
            this.btnPubN.Text = "Publish Notification";
            this.btnPubN.UseVisualStyleBackColor = false;
            this.btnPubN.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnPublish_Click);
            // 
            // btnExit
            // 
            this.btnExit.BackColor = System.Drawing.Color.Lavender;
            this.btnExit.Cursor = System.Windows.Forms.Cursors.Cross;
            this.btnExit.Location = new System.Drawing.Point(551, 72);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(116, 62);
            this.btnExit.TabIndex = 2;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = false;
            this.btnExit.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnExit_Click);
            // 
            // MenuForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Lavender;
            this.ClientSize = new System.Drawing.Size(713, 215);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnPubN);
            this.Controls.Add(this.btnManSubs);
            this.Name = "MenuForm";
            this.Text = "MenuForm";
            this.Load += new System.EventHandler(this.MenuForm_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnManSubs;
        private System.Windows.Forms.Button btnPubN;
        private System.Windows.Forms.Button btnExit;
    }
}