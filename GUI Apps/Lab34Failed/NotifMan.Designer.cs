namespace Lab34
{
    partial class NotifMan
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
            this.btnManSub = new System.Windows.Forms.Button();
            this.btnPushNotif = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnManSub
            // 
            this.btnManSub.Cursor = System.Windows.Forms.Cursors.Cross;
            this.btnManSub.Location = new System.Drawing.Point(12, 68);
            this.btnManSub.Name = "btnManSub";
            this.btnManSub.Size = new System.Drawing.Size(198, 49);
            this.btnManSub.TabIndex = 0;
            this.btnManSub.Text = "Manage Subscription";
            this.btnManSub.UseVisualStyleBackColor = true;
            this.btnManSub.Click += new System.EventHandler(this.btnManSub_Click);
            // 
            // btnPushNotif
            // 
            this.btnPushNotif.Cursor = System.Windows.Forms.Cursors.Cross;
            this.btnPushNotif.Enabled = false;
            this.btnPushNotif.Location = new System.Drawing.Point(237, 68);
            this.btnPushNotif.Name = "btnPushNotif";
            this.btnPushNotif.Size = new System.Drawing.Size(198, 49);
            this.btnPushNotif.TabIndex = 1;
            this.btnPushNotif.Text = "Publish Notification";
            this.btnPushNotif.UseVisualStyleBackColor = true;
            // 
            // btnExit
            // 
            this.btnExit.Cursor = System.Windows.Forms.Cursors.Cross;
            this.btnExit.Location = new System.Drawing.Point(458, 68);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(103, 49);
            this.btnExit.TabIndex = 2;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // NotifMan
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(573, 187);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnPushNotif);
            this.Controls.Add(this.btnManSub);
            this.Cursor = System.Windows.Forms.Cursors.PanNorth;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.Name = "NotifMan";
            this.Text = "Notification Manager";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnManSub;
        private System.Windows.Forms.Button btnPushNotif;
        private System.Windows.Forms.Button btnExit;
    }
}

