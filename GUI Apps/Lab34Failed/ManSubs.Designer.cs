namespace Lab34
{
    partial class ManSubs
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
            this.radBtnEmailNotif = new System.Windows.Forms.CheckBox();
            this.radBtnNotifSMS = new System.Windows.Forms.CheckBox();
            this.txtBEmail = new System.Windows.Forms.TextBox();
            this.txtBoxSMS = new System.Windows.Forms.TextBox();
            this.btnSub = new System.Windows.Forms.Button();
            this.btnUnSub = new System.Windows.Forms.Button();
            this.btnCancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // radBtnEmailNotif
            // 
            this.radBtnEmailNotif.AutoSize = true;
            this.radBtnEmailNotif.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.radBtnEmailNotif.Location = new System.Drawing.Point(50, 87);
            this.radBtnEmailNotif.Name = "radBtnEmailNotif";
            this.radBtnEmailNotif.Size = new System.Drawing.Size(208, 24);
            this.radBtnEmailNotif.TabIndex = 0;
            this.radBtnEmailNotif.Text = "Notification Sent by Email";
            this.radBtnEmailNotif.UseVisualStyleBackColor = true;
            this.radBtnEmailNotif.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
            // 
            // radBtnNotifSMS
            // 
            this.radBtnNotifSMS.AutoSize = true;
            this.radBtnNotifSMS.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.radBtnNotifSMS.Location = new System.Drawing.Point(50, 189);
            this.radBtnNotifSMS.Name = "radBtnNotifSMS";
            this.radBtnNotifSMS.Size = new System.Drawing.Size(208, 24);
            this.radBtnNotifSMS.TabIndex = 1;
            this.radBtnNotifSMS.Text = "Notification Sent by  SMS";
            this.radBtnNotifSMS.UseVisualStyleBackColor = true;
            // 
            // txtBEmail
            // 
            this.txtBEmail.Enabled = false;
            this.txtBEmail.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtBEmail.Location = new System.Drawing.Point(331, 85);
            this.txtBEmail.Name = "txtBEmail";
            this.txtBEmail.ScrollBars = System.Windows.Forms.ScrollBars.Horizontal;
            this.txtBEmail.Size = new System.Drawing.Size(290, 26);
            this.txtBEmail.TabIndex = 2;
            // 
            // txtBoxSMS
            // 
            this.txtBoxSMS.Enabled = false;
            this.txtBoxSMS.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtBoxSMS.Location = new System.Drawing.Point(331, 189);
            this.txtBoxSMS.Name = "txtBoxSMS";
            this.txtBoxSMS.ScrollBars = System.Windows.Forms.ScrollBars.Horizontal;
            this.txtBoxSMS.Size = new System.Drawing.Size(290, 26);
            this.txtBoxSMS.TabIndex = 3;
            // 
            // btnSub
            // 
            this.btnSub.Location = new System.Drawing.Point(62, 284);
            this.btnSub.Name = "btnSub";
            this.btnSub.Size = new System.Drawing.Size(150, 56);
            this.btnSub.TabIndex = 4;
            this.btnSub.Text = "Subscribe";
            this.btnSub.UseVisualStyleBackColor = true;
            // 
            // btnUnSub
            // 
            this.btnUnSub.Location = new System.Drawing.Point(304, 284);
            this.btnUnSub.Name = "btnUnSub";
            this.btnUnSub.Size = new System.Drawing.Size(150, 56);
            this.btnUnSub.TabIndex = 5;
            this.btnUnSub.Text = "Unsubscribe";
            this.btnUnSub.UseVisualStyleBackColor = true;
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(537, 284);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(97, 56);
            this.btnCancel.TabIndex = 6;
            this.btnCancel.Text = "Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            // 
            // ManSubs
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.GradientInactiveCaption;
            this.ClientSize = new System.Drawing.Size(722, 363);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnUnSub);
            this.Controls.Add(this.btnSub);
            this.Controls.Add(this.txtBoxSMS);
            this.Controls.Add(this.txtBEmail);
            this.Controls.Add(this.radBtnNotifSMS);
            this.Controls.Add(this.radBtnEmailNotif);
            this.Name = "ManSubs";
            this.Text = "Manage Subscriptions";
            this.Load += new System.EventHandler(this.ManSubs_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.CheckBox radBtnEmailNotif;
        private System.Windows.Forms.CheckBox radBtnNotifSMS;
        private System.Windows.Forms.TextBox txtBEmail;
        private System.Windows.Forms.TextBox txtBoxSMS;
        private System.Windows.Forms.Button btnSub;
        private System.Windows.Forms.Button btnUnSub;
        private System.Windows.Forms.Button btnCancel;
    }
}